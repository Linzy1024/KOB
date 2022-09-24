package com.linzy.backend.controller.user.bot;

import com.linzy.backend.service.user.bot.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateController {
    @Autowired
    private UpdateService updateService;

    @PostMapping("/user/bot/update")
    public Map<String, String> update(@RequestParam Map<String, String> data) {
        return updateService.udpate(data);
    }
}
