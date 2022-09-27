package com.linzy.kob.backend.controller.user.bot;

import com.linzy.kob.backend.service.user.bot.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemoveController {
    @Autowired
    private RemoveService removeService;

    @PostMapping("/api/user/bot/remove")
    public Map<String, String> remove(@RequestParam  Map<String, String> data) {
        return removeService.remove(data);
    }
}
