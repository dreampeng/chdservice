package com.apesing.chd.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 **/
@RestController
@RequestMapping(value = "/", produces = {"application/json"})
public class IndexControllerTemp {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String passWord;

    @GetMapping("/")
    public JSONObject index() {
        JSONObject json = new JSONObject();
        json.put("code", "0000");
        json.put("msg", "启动成功");
        return json;
    }

    @GetMapping("/config/{pass}")
    public JSONObject getConfig(@PathVariable("pass") String pass) {
        JSONObject json = new JSONObject();
        if ("815566704".equals(pass)) {
            json.put("url", url);
            json.put("userName", userName);
            json.put("passWord", passWord);
        }
        return json;
    }
}
