package com.example.telegrambot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class BotProperties {
    private String botUserName;
    private String token;

    public String getBotUserName() {
        return botUserName;
    }

    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
