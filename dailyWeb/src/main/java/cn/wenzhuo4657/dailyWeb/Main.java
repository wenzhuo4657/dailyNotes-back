package cn.wenzhuo4657.dailyWeb;


import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.nio.file.Path;
import java.nio.file.Paths;








@SpringBootApplication
@EnableScheduling
@MapperScan("cn.wenzhuo4657.dailyWeb.infrastructure.database.dao")
public class Main  implements ApplicationRunner {
    private final static Logger log = org.slf4j.LoggerFactory.getLogger(Main.class);



    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        log.info("启动成功");
        log.info("Sa-Token 配置如下：" + SaManager.getConfig());
    }







    private static  Path filePath;

    private static Path dbfilePath;


    public static Path getFilePath() {
        return filePath;
    }

    public static Path getDbfilePath() {
        return dbfilePath;
    }



    @Autowired
    private  Environment  env;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String property = env.getProperty("dir.beifen");
        filePath = Paths.get(property);

        String property1 = env.getProperty("dir.db");
        dbfilePath = Paths.get(property,property1);
    }

}
