package cn.wenzhuo4657.dailyWeb.domain.email;

import org.springframework.stereotype.Service;


public interface EmailService {

    /**
     * 发送备份至邮箱（邮箱配置来自cn.wenzhuo4657.dailyWeb.config.EmailProperties）
     *
     */
    public  boolean sendEmail();
}
