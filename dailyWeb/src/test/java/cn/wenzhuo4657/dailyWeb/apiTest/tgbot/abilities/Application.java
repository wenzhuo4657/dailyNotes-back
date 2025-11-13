package cn.wenzhuo4657.dailyWeb.apiTest.tgbot.abilities;


import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Application {
    public static void main(String[] args) {


        /**
         * 不能用，报错 Cannot invoke "java.util.List.stream()" because "this.replies" is null
         */

        String botToken = System.getenv("tgBot");
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            MyAmazingBot myAmazingBot = new MyAmazingBot(botToken,"helloBot");
            botsApplication.registerBot(botToken,myAmazingBot );
            System.out.println("MyAmazingBot successfully started!");
            // Ensure this prcess wait forever
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}