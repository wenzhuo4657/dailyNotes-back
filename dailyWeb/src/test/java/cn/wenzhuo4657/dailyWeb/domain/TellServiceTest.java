package cn.wenzhuo4657.dailyWeb.domain;

import cn.wenzhuo4657.dailyWeb.domain.tell.service.ITellService;
import cn.wenzhuo4657.dailyWeb.domain.tell.service.strategy.NotifierMessage;
import cn.wenzhuo4657.dailyWeb.domain.tell.service.strategy.NotifierResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TellServiceTest {

    @Autowired
    ITellService tellService;

    @Test
    public void test(){
        NotifierMessage message=new NotifierMessage();
        message.setTitle("测试通知");
        message.setContent("这是一个测试通知内容。");
        NotifierResult result = tellService.sendNotify(0, "gmail", message);
        System.out.println(result);
    }


    @Test
    public void test1(){
        NotifierMessage message=new NotifierMessage();
        message.setTitle("测试通知(含附件)");
        message.setContent("这是一个测试通知内容。");

        message.setFile(getFile());
        NotifierResult result = tellService.sendNotify(0, "gmail", message);
        System.out.println(result);
    }


    private  File getFile(){

        try {
            ClassLoader classLoader = getClass().getClassLoader();

            // 2. 获取资源的 URL
            URL resourceUrl = classLoader.getResource("1.txt");

            // 3. 从 URL 创建 File 对象
            File file = new File(resourceUrl.toURI());

            return file;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
