package com.linzy.kob.botrunningsystem;

import com.linzy.kob.botrunningsystem.service.impl.BotRunningServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotRunningSystemApplication {
    public static void main(String[] args) {
        BotRunningServiceImpl.botpool.start(); // 启动botPool线程
        SpringApplication.run(BotRunningSystemApplication.class, args);
    }
}
