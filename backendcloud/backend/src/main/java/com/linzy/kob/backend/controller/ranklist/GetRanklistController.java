package com.linzy.kob.backend.controller.ranklist;

import com.alibaba.fastjson.JSONObject;
import com.linzy.kob.backend.service.ranklist.GetRanklistServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRanklistController {

    @Autowired
    private GetRanklistServie getRanklistServie;

    @GetMapping("/api/ranklist/getlist")
    public JSONObject getList(Integer page) {
        return getRanklistServie.getList(page);
    }
}
