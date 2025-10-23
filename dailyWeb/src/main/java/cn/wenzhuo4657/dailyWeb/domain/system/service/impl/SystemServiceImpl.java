package cn.wenzhuo4657.dailyWeb.domain.system.service.impl;

import cn.wenzhuo4657.dailyWeb.domain.system.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private DataSource dataSource;


    ReentrantLock alock=new ReentrantLock(true);

    ReentrantLock block=new ReentrantLock(true);

    @Override
    public void reset(File tempFile) {

        try {
            alock.tryLock(60, TimeUnit.SECONDS);



            //  不能原子替换，进程锁定了当前db文件 :ATTACH DATABASE后合并数据，
            try (Connection backendConn =dataSource.getConnection();
                 Statement stmt = backendConn.createStatement()) {

                backendConn.setAutoCommit(false); // 开启事务

                // 使用 Statement 执行 ATTACH DATABASE
                String attachSql = "ATTACH DATABASE '" + tempFile.getAbsolutePath() + "' AS tempDb;";
                stmt.execute(attachSql);

                // **合并 表数据**
//            TODO sql脚本，以后数据库一定会变，所以之后要注意对不同版本的数据库进行兼容，对于库表版本进行标记，
//            1，清除原表数据
                String deleteSql = """
                    DELETE FROM main.content_item;
                    DELETE FROM main.content_name;
                    DELETE FROM main.content_type;
            """;
                stmt.executeUpdate(deleteSql);
//            2，添加新库数据
                String insertSql = """
                  
                   INSERT INTO main.content_type (id, name, des)
                   SELECT id, name, des FROM tempDb.content_type;
                   
                   INSERT INTO main.content_name (id, name, "type", create_time, update_time)
                   SELECT id, name, "type", create_time, update_time FROM tempDb.content_name;
                   
                   INSERT INTO main.content_item (id, content_name_id, item_content, item_Field, date)
                   SELECT id, content_name_id, item_content, item_Field, date FROM tempDb.content_item;
                   """;
                stmt.executeUpdate(insertSql);

                backendConn.commit(); // 提交事务

                stmt.execute("DETACH DATABASE tempDb;");
            } catch (Exception e) {
                throw new RuntimeException("数据库导入失败", e);
            }finally {
                boolean delete = tempFile.delete();
                System.out.println("删除临时文件：" + delete);
            }


        }catch (InterruptedException e) {
            log.error("排队超时",e);
        }finally {
            alock.unlock();
        }


    }

    @Override
    public void export(Path tempBackup) throws SQLException {
        try {
            block.tryLock(10, TimeUnit.SECONDS);
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(true);

            String string = tempBackup.toAbsolutePath().toString();

            connection.createStatement().execute("VACUUM INTO '" + string + "';");

        }catch (InterruptedException e){
            log.error("排队超时",e);
        }finally {
            block.unlock();
        }

    }
}
