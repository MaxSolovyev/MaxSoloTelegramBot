package com.example.telegrambot.model.dto;

import java.util.Objects;

public class BotDto {
    private String name;
    private String token;

    public BotDto() {
    }

    public BotDto(String name, String token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotDto botDto = (BotDto) o;
        return name.equals(botDto.name) &&
                token.equals(botDto.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, token);
    }

    @Override
    public String toString() {
        return "BotDto{" +
                "name='" + name + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
