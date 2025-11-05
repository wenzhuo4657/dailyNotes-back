package cn.wenzhuo4657.dailyWeb.domain;

import cn.wenzhuo4657.dailyWeb.domain.email.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSendEmail() {
        boolean result = emailService.sendEmail();
        System.out.println("邮件发送结果：" + result);
    }
}
