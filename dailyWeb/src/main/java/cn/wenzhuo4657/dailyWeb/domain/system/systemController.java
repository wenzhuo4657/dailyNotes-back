package cn.wenzhuo4657.dailyWeb.domain.system;


import cn.wenzhuo4657.dailyWeb.Main;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Slf4j
@RestController(value = "system")
public class systemController {


    @Autowired
    private DataSource dataSource;

    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    /**
     * 直链下载sqlite文件,
     * 核心使用： VACUUM   INTO  "new_file_name"
     * 参考： https://sqlite.org/lang_vacuum.html
     *
     */
    @RequestMapping(
            value = "DownLoadFile",
            method = RequestMethod.GET
    )
    public ResponseEntity<Resource> DownLoadFile() {
        try {

            Path filePath= Main.getFilePath();
            String ts = LocalDateTime.now().format(TS);
            Path tempBackup  = filePath.resolve("beifen-" + ts + ".db");

            try {
                Connection connection = dataSource.getConnection();
                connection.setAutoCommit(true);

                String string = tempBackup.toAbsolutePath().toString();

                connection.createStatement().execute("VACUUM INTO '" + string + "';");

            }catch (Exception e){
                log.error("获取数据库连接失败",e);
                return ResponseEntity.status(500).body(null);
            }


            long size = Files.size(tempBackup);
            InputStreamResource body = new InputStreamResource(Files.newInputStream(tempBackup));



            ContentDisposition cd = ContentDisposition.attachment()
                    .filename(tempBackup.getFileName().toString(), StandardCharsets.UTF_8)
                    .build();


            ResponseEntity<Resource> res = ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, cd.toString())
                    .header(HttpHeaders.CACHE_CONTROL, "no-store") // 按需调整缓存策略
                    .contentLength(size)
                    .body(body);

            return res;
        }catch (IOException e){
            log.error("下载文件失败",e);
            return ResponseEntity.status(500).body(null);
        }
    }




    /**
     * 上传sqlite，做系统恢复
     */
    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {


// todo 疑似有并发风险，导致 tempDb卸载失败
//        （1） The database file is locked (database is locked)
//        （2）SQL error or missing database (database tempDb is already in use)

        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("{\"error\":\"文件为空\"}");
        }

        Path filePath = Main.getFilePath();

        Path temp = filePath.resolve(file.getOriginalFilename());


        try (InputStream in = file.getInputStream()) {
            Files.copy(in, temp, REPLACE_EXISTING);
        }
        File tempFile = temp.toFile();

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






        return ResponseEntity.ok().build();
    }


}
