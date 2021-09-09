package com.example.telegrambot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(BotProperties.class)
public class BotConfiguration {

    @Autowired
    BotProperties properties;

    private TelegramBotsApi telegramBotsApi;

    @PostConstruct
    public void Init() throws TelegramApiException {
        telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
    }

    public String getBotUserName() {
        return properties.getBotUserName();
    }

    public String getBotToken() {
        return properties.getBotToken();
    }

    public TelegramBotsApi getTelegramBotsApi() {
        return telegramBotsApi;
    }
}
