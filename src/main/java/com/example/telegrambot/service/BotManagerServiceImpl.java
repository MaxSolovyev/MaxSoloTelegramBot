package com.example.telegrambot.service;

import com.example.telegrambot.model.BotInfo;
import com.example.telegrambot.model.dto.BotDto;
import com.example.telegrambot.repository.BotInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BotManagerServiceImpl implements BotManagerService {
    private BotInfoRepository botInfoRepository;
    private BotsListenerService botsListenerService;

    @Autowired
    public BotManagerServiceImpl(BotInfoRepository botInfoRepository, BotsListenerService botsListenerService) {
        this.botInfoRepository = botInfoRepository;
        this.botsListenerService = botsListenerService;
    }

    @Transactional
    @Override
    public void register(BotDto botDto) {
        List<BotInfo> botInfoList = botInfoRepository.findByName(botDto.getName());
        if (botInfoList.isEmpty()) {
            BotInfo botInfo = botInfoRepository.save(new BotInfo(botDto.getName(), botDto.getToken()));
            botsListenerService.addBotForListener(botInfo);
        }
    }

    @Transactional
    @Override
    public void unregister(String botName) {
        botInfoRepository.findByName(botName).forEach(info -> {
            botInfoRepository.delete(info);
            botsListenerService.removeFromListener(info.getName());
        });
    }

    @Override
    public List<BotDto> getAll() {
        return botInfoRepository
                .findAll()
                .stream()
                .map(info -> new BotDto(info.getName(), info.getToken()))
                .collect(Collectors.toList());
    }
}
