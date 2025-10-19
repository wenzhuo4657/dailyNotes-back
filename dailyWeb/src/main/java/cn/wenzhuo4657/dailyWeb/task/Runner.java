package cn.wenzhuo4657.dailyWeb.task;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;




@Slf4j
@Component
public class Runner {


    /**
     * 定时邮件备份，每天0（UTC+8）点执行
     * 1，gmail smtp邮件客户端配置，邮件备份+本地目录备份
     * (1,邮箱需要在线配置
     * 2，（可选）tg通知配置，执行失败进行通知
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void backup() {
      log.info("定时任务: 备份   -start");

      try {

      } catch (Exception e) {
        log.error("定时任务: 邮件备份失败",e);
      }
      log.info("定时任务: 邮件备份   -end");

    }

}
