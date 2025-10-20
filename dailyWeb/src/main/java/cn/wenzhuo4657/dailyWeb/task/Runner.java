package cn.wenzhuo4657.dailyWeb.task;


import cn.wenzhuo4657.dailyWeb.domain.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;




@Slf4j
@Component
public class Runner {

    @Autowired
    private EmailService emailService;


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
