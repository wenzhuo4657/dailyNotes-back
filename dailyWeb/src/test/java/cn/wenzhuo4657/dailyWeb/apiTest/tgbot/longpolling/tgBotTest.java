package cn.wenzhuo4657.dailyWeb.apiTest.tgbot.longpolling;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * 功能需求
 * 1，主动通信，
 * 通信对象：机器人拥有者，可以通过会话锁定（需要会话保活）
 * 通信对象：机器人订阅者(存疑，是否有可能？）
 * 2，指令（搁置：先进行简单api测试）
 */

public class tgBotTest {

    public static void main(String[] args) throws TelegramApiException {
        String botToken = System.getenv("tgBot");
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(botToken, new MyAmazingBot(botToken));
            System.out.println("MyAmazingBot successfully started!");
            // Ensure this prcess wait forever
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }







    }

}
