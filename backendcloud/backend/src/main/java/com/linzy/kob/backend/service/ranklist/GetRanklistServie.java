package com.linzy.kob.backend.service.ranklist;

import com.alibaba.fastjson.JSONObject;

public interface GetRanklistServie {
    JSONObject getList(Integer page);
}
