package com.example.telegrambot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BotProperties.class)
public class BotConfiguration {

    @Autowired
    BotProperties properties;

    public String getBotUserName() {
        return properties.getBotUserName();
    }

    public String getBotToken() {
        return properties.getBotToken();
    }
}
