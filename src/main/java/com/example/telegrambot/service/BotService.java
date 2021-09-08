package com.example.telegrambot.service;

import com.example.telegrambot.configuration.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class BotService extends TelegramLongPollingBot {
    BotConfiguration botConfiguration;

    @Autowired
    public BotService(BotConfiguration botConfiguration) {
        this.botConfiguration = botConfiguration;
    }

    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        SendMessage.SendMessageBuilder builder = SendMessage.builder();
        String messageText;
        String chatId;
        if (update.getMessage() != null) {
            chatId = update.getMessage().getChatId().toString();
            builder.chatId(chatId);
            messageText = update.getMessage().getText();
        } else {
            chatId = update.getChannelPost().getChatId().toString();
            builder.chatId(chatId);
            messageText = update.getChannelPost().getText();
        }

        builder.text(messageText);
        try {
            execute(builder.build());
        } catch (TelegramApiException e) {
            System.out.println(e.toString());
        }
    }

    public String getBotUsername() {
        return botConfiguration.getBotUserName();
    }

    public String getBotToken() {
        return botConfiguration.getBotToken();
    }
}
