package cn.wenzhuo4657.dailyWeb.tigger.task;


import cn.wenzhuo4657.dailyWeb.domain.email.EmailService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;





@Component
public class Runner {

    @Autowired
    private EmailService emailService;

    private final static Logger log= org.slf4j.LoggerFactory.getLogger(Runner.class);


    /**
     * 定时邮件备份，每天0（UTC+8）点执行
     * 2，（可选）tg通知配置，执行失败进行通知
     */
    @Scheduled(cron = "0 0 0 * * ?",zone = "Asia/Shanghai")
    public void backup() {
      log.info("定时任务: 备份   -start");

      try {

          emailService.sendEmail();



      } catch (Exception e) {
        log.error("定时任务: 邮件备份失败",e);
      }
      log.info("定时任务: 邮件备份   -end");

    }

}
