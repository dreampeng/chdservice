package com.apesing.chd.controller;

import com.alibaba.fastjson.JSONObject;
import com.apesing.chd.service.AccountService;
import com.apesing.chd.service.VerifyCodeService;
import com.apesing.chd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 **/
@RestController
    @RequestMapping(value = "/verify", produces = {"application/json"})
public class VerifyCodeController {
    private VerifyCodeService verifyCodeService;
    private AccountService accountService;

    @Autowired
    public VerifyCodeController(com.apesing.chd.service.VerifyCodeService verifyCodeService, AccountService accountService) {
        this.verifyCodeService = verifyCodeService;
        this.accountService = accountService;
    }

    @PostMapping("/get/{type}")
    public JSONObject getVerifyCode(@RequestBody JSONObject json, @PathVariable("type") String type) {
        JSONObject retJson = new JSONObject();
        String mail = json.getString("mail");
        String code;
        if (StringUtil.isEmpty(mail)) {
            code = "9998";
        } else {
            if ("1".equals(type) && accountService.getAccountByMail(mail) != null) {
                code = "9002";
            } else {
                verifyCodeService.sendMailCode(mail, type);
                code = "0000";
            }
        }
        retJson.put("code", code);
        return retJson;
    }
}
