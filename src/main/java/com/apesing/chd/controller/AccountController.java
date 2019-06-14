package com.apesing.chd.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关
 */
@RestController
@RequestMapping(value = "/account", produces = {"application/json"})
public class AccountController {
    @PostMapping("/{account}/{password}")
    public JSONObject regist(@PathVariable("account") String account,
                             @PathVariable("password") String password) {
        JSONObject retJson = new JSONObject();
        retJson.put("code","0000");
        return retJson;
    }
}
