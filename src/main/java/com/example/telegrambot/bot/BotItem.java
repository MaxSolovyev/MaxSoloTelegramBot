package com.example.telegrambot.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotItem extends TelegramLongPollingBot {
    private String botName;
    private String token;

    public BotItem(String botName, String token) {
        this.botName = botName;
        this.token = token;
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
        return botName;
    }

    public String getBotToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
