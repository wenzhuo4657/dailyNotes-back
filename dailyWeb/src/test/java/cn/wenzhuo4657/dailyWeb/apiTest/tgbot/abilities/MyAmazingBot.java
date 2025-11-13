package cn.wenzhuo4657.dailyWeb.apiTest.tgbot.abilities;

import org.telegram.telegrambots.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.abilitybots.api.objects.Locality;
import org.telegram.telegrambots.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class MyAmazingBot extends AbilityBot {

    protected MyAmazingBot(String botToken,String botUsername) {
        super(new OkHttpTelegramClient(botToken), botUsername);

    }

    @Override
    public long creatorId() {
//        机器人开发者ID。即机器人管理员
        return 312313;
    }


    public Ability sayHelloWorld() {
        return Ability
                .builder()
                .name("hello")
                .info("says hello world!")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> silent.send("Hello world!", ctx.chatId()))
                .build();
    }


}
