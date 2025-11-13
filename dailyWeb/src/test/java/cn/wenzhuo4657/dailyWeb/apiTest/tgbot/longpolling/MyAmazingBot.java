package cn.wenzhuo4657.dailyWeb.apiTest.tgbot.longpolling;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.commands.GetMyCommands;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.photo.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyAmazingBot implements LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient telegramClient;

    public MyAmazingBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
        SetMyCommands setMyCommands = SetMyCommands
                .builder()
                .languageCode("zh")
                .scope(BotCommandScopeDefault.builder().build())
                .build();
        List<BotCommand> commands = new ArrayList<>();


        commands.add(BotCommand.builder().command("test11").description("解释").build());
        setMyCommands.setCommands(commands);

        GetMyCommands getMyCommands = GetMyCommands
                .builder()
                .languageCode("en")
                .scope(BotCommandScopeDefault.builder().build())
                .build();

        try {
            telegramClient.execute(setMyCommands);
            telegramClient.execute(getMyCommands);
            System.out.println(getMyCommands);
            String method = getMyCommands.getMethod();
            System.out.println(method);

        }catch (TelegramApiException e){
            e.printStackTrace();
        }

    }
    @Override
    public void consume(Update update) {
        //1，检查是否有小小
        if (update.hasMessage()  ) {


//            包含照片：
            if (update.getMessage().hasPhoto()){
                long chat_id = update.getMessage().getChatId();
                List<PhotoSize> photos = update.getMessage().getPhoto();
                // Know file_id
                String f_id = photos.stream().max(Comparator.comparing(PhotoSize::getFileSize))
                        .map(PhotoSize::getFileId)
                        .orElse("");
                // Know photo width
                int f_width = photos.stream().max(Comparator.comparing(PhotoSize::getFileSize))
                        .map(PhotoSize::getWidth)
                        .orElse(0);
                // Know photo height
                int f_height = photos.stream().max(Comparator.comparing(PhotoSize::getFileSize))
                        .map(PhotoSize::getHeight)
                        .orElse(0);
                // Set photo caption
                String caption = "file_id: " + f_id + "\nwidth: " + Integer.toString(f_width) + "\nheight: " + Integer.toString(f_height);
                SendPhoto msg = SendPhoto
                        .builder()
                        .chatId(chat_id)
                        .photo(new InputFile(f_id))
                        .caption(caption)
                        .build();

                try {
                    telegramClient.execute(msg); // Call method to send the photo with caption
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }

//            包含文本： 复读机回复
            if (update.getMessage().hasText()){
                // Set variables
                String message_text = update.getMessage().getText();
                SendMessage message;
                long chat_id = update.getMessage().getChatId();
                if (message_text.equals("/markup")){
                    message= SendMessage // Create a message object object
                            .builder()
                            .chatId(chat_id)
                            .text("Here is your keyboard")
                            .build();

                    // Add the keyboard to the message
                    message.setReplyMarkup(ReplyKeyboardMarkup
                            .builder()
                            // Add first row of 3 buttons
                            .keyboardRow(new KeyboardRow("Row 1 Button 1", "Row 1 Button 2", "Row 1 Button 3"))
                            // Add second row of 3 buttons
                            .keyboardRow(new KeyboardRow("Row 2 Button 1", "Row 2 Button 2", "Row 2 Button 3"))
                            .build());
                }else {
                    message = SendMessage // Create a message object
                            .builder()
                            .chatId(chat_id)
                            .text(message_text)
                            .build();

                }



                try {
                    telegramClient.execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}