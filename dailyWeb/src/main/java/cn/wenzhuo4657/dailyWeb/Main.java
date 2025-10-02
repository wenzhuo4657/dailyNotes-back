package cn.wenzhuo4657.dailyWeb;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@SpringBootApplication
public class Main implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    todo  1，md文件编辑 2，每日邮件备份：程序内实现，没必要写脚本    3，tg通知（目前的想法是如果备份失败通过tg进行提醒）







    private static  Path filePath;


    public static Path getFilePath() {
        return filePath;
    }

    @Resource
    private Environment env;

    @Override
    public void run(ApplicationArguments args) throws Exception {

       String fileName="content.md";
       String beifen = env.getProperty("dir.beifen");

        log.info("初始化文件  备份路径:{}",beifen);


        Path filePath = Paths.get(beifen, fileName);
        Path parent = filePath.getParent();

        // 创建父目录
        if (parent != null) {
            Files.createDirectories(parent);
        }

        // 如果路径已经存在且是目录，提示错误
        if (Files.isDirectory(filePath)) {
            throw new IOException("目标路径已是目录: " + filePath);
        }

        // 不存在则创建空文件（存在就跳过）
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
        this.filePath = filePath;
        log.info("初始化完成  path: {}",filePath.toString());
    }


}
