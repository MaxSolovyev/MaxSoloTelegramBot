package com.example.telegrambot.bot;

import com.example.telegrambot.exceptions.BotTypeIsNotFound;
import com.example.telegrambot.model.BotInfo;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public abstract class AbstractBotItem extends TelegramLongPollingBot {
    private String botName;
    private String token;

    public AbstractBotItem(String botName, String token) {
        this.botName = botName;
        this.token = token;
    }

    public static AbstractBotItem getBotItemByType(BotInfo botInfo) throws BotTypeIsNotFound {
        if (botInfo.getType() == null) {
            throw new BotTypeIsNotFound();
        }
        switch (botInfo.getType()) {
            case COMMAND:
                return new BotItemCommands(botInfo.getName(), botInfo.getToken());
            case KEYBOARD:
                return new BotItemKeyboard(botInfo.getName(), botInfo.getToken());
            case DIALOGFLOW:
                return new BotItemDialogFlow(botInfo.getName(), botInfo.getToken());
            default:
                throw new BotTypeIsNotFound();
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
