package com.linzy.backend.controller.user.bot;

import com.linzy.backend.pojo.Bot;
import com.linzy.backend.service.user.bot.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetListController {
    @Autowired
    private GetListService getListService;

    @GetMapping("/user/bot/getlist")
    public List<Bot> getList() {
        return getListService.getList();
    }
}
