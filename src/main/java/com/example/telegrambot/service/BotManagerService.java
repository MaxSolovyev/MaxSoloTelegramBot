package com.example.telegrambot.service;

import com.example.telegrambot.model.dto.BotDto;

import java.util.List;

public interface BotManagerService {
    void register(BotDto botDto);
    void unregister(String botName);
    List<BotDto> getAll();
}
