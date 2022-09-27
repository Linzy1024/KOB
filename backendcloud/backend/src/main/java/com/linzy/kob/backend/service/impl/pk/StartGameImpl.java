package com.linzy.kob.backend.service.impl.pk;

import com.linzy.kob.backend.consumer.WebSocketServer;
import com.linzy.kob.backend.service.pk.StartGameService;
import org.springframework.stereotype.Service;

@Service
public class StartGameImpl implements StartGameService {

    @Override
    public String startGame(Integer aId, Integer aBotId, Integer bId, Integer bBotId) {
        WebSocketServer.startGame(aId, aBotId, bId, bBotId);

        return "start game...";
    }
}
