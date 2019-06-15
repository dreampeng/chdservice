package com.apesing.chd.controller;

import com.alibaba.fastjson.JSONObject;
import com.apesing.chd.service.SysnoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notice", produces = {"application/json"})
public class SysNoticeController {
    private final SysnoticeService sysnoticeService;

    @Autowired
    public SysNoticeController(SysnoticeService sysnoticeService) {
        this.sysnoticeService = sysnoticeService;
    }

    @GetMapping("/top/{type}")
    public JSONObject getTopNotice(@PathVariable String type) {
        JSONObject json = new JSONObject();
        json.put("code", "0000");
        json.put("data", sysnoticeService.getNotice(type, null));
        return json;
    }
}
