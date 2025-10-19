package cn.wenzhuo4657.dailyWeb.domain.email;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    /**
     * 发送邮件
     *
     */
    public  boolean sendEmail();
}
