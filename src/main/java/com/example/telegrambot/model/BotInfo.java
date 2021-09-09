package com.example.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class BotInfo {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    private String name;
    private String token;

    public BotInfo() {
    }

    public BotInfo(long id, String name, String token) {
        this.id = id;
        this.name = name;
        this.token = token;
    }

    public BotInfo(String name, String token) {
        this.name = name;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public String toString() {
        return "BotInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
