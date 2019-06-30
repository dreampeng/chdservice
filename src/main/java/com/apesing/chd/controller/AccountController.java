package com.apesing.chd.controller;

import com.alibaba.fastjson.JSONObject;
import com.apesing.chd.entity.TbluAccount;
import com.apesing.chd.service.AccountService;
import com.apesing.chd.service.VerifyCodeService;
import com.apesing.chd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 用户相关
 */
@RestController
@RequestMapping(value = "/account", produces = {"application/json"})
public class AccountController {
    private VerifyCodeService verifyCodeService;
    private AccountService accountService;
    private HttpSession session;

    @Autowired
    public AccountController(com.apesing.chd.service.VerifyCodeService verifyCodeService, AccountService accountService
            , HttpSession session) {
        this.verifyCodeService = verifyCodeService;
        this.accountService = accountService;
        this.session = session;
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
            if (accountService.getAccountById(userName) != null) {
                code = "9001";
            } else if (accountService.getAccountByMail(mail) != null) {
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

    @PostMapping("/isreg")
    public JSONObject isRegister(@RequestBody JSONObject json) {
        JSONObject retJson = new JSONObject();
        String type = json.getString("type");
        String addr = json.getString("addr");
        String code;
        if (StringUtil.isEmpty(type, addr)) {
            code = "9998";
        } else {
            if ("1".equals(type) && accountService.getAccountById(addr) != null) {
                code = "9001";
            } else if ("2".equals(type) && accountService.getAccountByMail(addr) != null) {
                code = "9002";
            } else {
                code = "0000";
            }
        }
        retJson.put("code", code);
        return retJson;
    }

    @PostMapping("/login")
    public JSONObject login(@RequestBody JSONObject json) {
        JSONObject retJson = new JSONObject();
        String userName = json.getString("userName");
        String userPass = json.getString("userPass");
        String code;
        if (StringUtil.isEmpty(userName, userPass)) {
            code = "9998";
        } else {
            TbluAccount tbluAccount = accountService.userLogin(userName, userPass);
            if (tbluAccount != null) {
                session.setAttribute("user", tbluAccount);
                code = "0000";
            } else {
                code = "9000";
            }
        }
        retJson.put("code", code);
        return retJson;
    }
}
