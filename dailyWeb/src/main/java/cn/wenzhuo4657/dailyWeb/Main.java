package cn.wenzhuo4657.dailyWeb;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
//    todo   2，每日邮件备份：程序内实现，没必要写脚本    3，tg通知（目前的想法是如果备份失败通过tg进行提醒）






@Slf4j
@SpringBootApplication
public class Main  implements ApplicationRunner {



    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }







    private static  Path filePath;


    public static Path getFilePath() {
        return filePath;
    }


    @Autowired
    private  Environment  env;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String property = env.getProperty("dir.beifen");
        filePath = Paths.get(property);
    }
}
