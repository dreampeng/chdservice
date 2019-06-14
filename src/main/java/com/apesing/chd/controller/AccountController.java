package com.apesing.chd.controller;

import com.alibaba.fastjson.JSONObject;
import com.apesing.chd.service.AccountService;
import com.apesing.chd.service.VerifyCodeService;
import com.apesing.chd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关
 */
@RestController
@RequestMapping(value = "/account", produces = {"application/json"})
public class AccountController {
    private VerifyCodeService verifyCodeService;
    private AccountService accountService;

    @Autowired
    public AccountController(com.apesing.chd.service.VerifyCodeService verifyCodeService, AccountService accountService) {
        this.verifyCodeService = verifyCodeService;
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public JSONObject register(@RequestBody JSONObject json) {
        JSONObject retJson = new JSONObject();
        String userName = json.getString("userName");
        String passWord = json.getString("passWord");
        String mail = json.getString("mail");
        String mailCode = json.getString("mailCode");
        String code;
        if (StringUtil.isEmpty(userName, passWord, mail, mailCode)) {
            code = "9998";
        } else {
            if (accountService.getAccountById(userName) == null) {
                code = "9001";
            } else if (accountService.getAccountByMail(mail) == null) {
                code = "9002";
            } else if (!verifyCodeService.verifyCode(mail, mailCode, "1")) {
                code = "9100";
            } else {
                accountService.addAccount(userName, passWord, mail);
                code = "0000";
            }
        }
        retJson.put("code", code);
        return retJson;
    }
}
