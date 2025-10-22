package cn.wenzhuo4657.dailyWeb;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;







@Slf4j
@SpringBootApplication
public class Main  implements ApplicationRunner {



    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
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
