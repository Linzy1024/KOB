package com.linzy.kob.botrunningsystem.service.impl.utils;

import org.joor.Reflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.function.Supplier;

@Component
public class Consumer extends Thread{
    private Bot bot;

    private static RestTemplate restTemplate;

    private final static String receiveBotMoveUrl = "http://127.0.0.1:8081/pk/receive/bot/move";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        Consumer.restTemplate = restTemplate;
    }

    public void startTimeout(long timeout, Bot bot) {
        this.bot = bot;
        this.start();
        try {
            this.join(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }

    }

    private String addUid(String code, String uid) {
        int k = code.indexOf(" implements java.util.function.Supplier<Integer>");
        return code.substring(0, k) + uid + code.substring(k);
    }

    @Override
    public void run() {
        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString().substring(0, 8);
        Reflect compile = Reflect.compile(
                "com.linzy.kob.botrunningsystem.utils.Bot",
                bot.getBotCode()
        );
        Supplier<Integer> botInterface = Reflect.compile(
                "com.linzy.kob.botrunningsystem.utils.Bot",
                bot.getBotCode()
        ).create().get();

        File file = new File("input.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(bot.getInput());
            pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("about to call nextMove");
        Integer direction = botInterface.get();
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("user_id", bot.getUserId().toString());
        data.add("direction", direction.toString());
        System.out.println("consumer consume bot: " + data);
        restTemplate.postForObject(receiveBotMoveUrl, data, String.class);
    }
}
