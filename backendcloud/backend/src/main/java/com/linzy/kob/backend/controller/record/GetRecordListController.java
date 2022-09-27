package com.linzy.kob.backend.controller.record;


import com.alibaba.fastjson.JSONObject;
import com.linzy.kob.backend.service.record.GetRecordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetRecordListController {

    @Autowired
    private GetRecordListService getRecordListService;

    @GetMapping("/api/record/getlist")
    public JSONObject getList(@RequestParam Map<String, String> data) {
        int page = Integer.parseInt(data.get("page"));
        return getRecordListService.getList(page);
    }
}