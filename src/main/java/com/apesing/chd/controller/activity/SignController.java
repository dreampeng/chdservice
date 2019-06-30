package com.apesing.chd.controller.activity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.apesing.chd.entity.TbluAccount;
import com.apesing.chd.service.SignService;
import com.apesing.chd.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping(value = "/activity/sign", produces = {"application/json"})
public class SignController {
    private HttpSession session;
    private SignService signService;

    @Autowired
    public SignController(HttpSession session, SignService signService) {
        this.session = session;
        this.signService = signService;
    }

    @PostMapping("/get")
    public JSONObject getSignList() {
        JSONObject retJson = new JSONObject();
        TbluAccount tbluAccount = (TbluAccount) session.getAttribute("user");
        if (tbluAccount == null) {
            retJson.put("code","9997");
            return retJson;
        }
        retJson.put("code", "0000");
        retJson.put("data", signService.getSignedList(Integer.toString(TimeUtil.getYear(new Date())),
                Integer.toString(TimeUtil.getMonth(new Date())), tbluAccount.getId()));
        return retJson;
    }

    @PostMapping("/sign")
    public JSONObject sign() {
        JSONObject retJson = new JSONObject();
        TbluAccount tbluAccount = (TbluAccount) session.getAttribute("user");
        if (tbluAccount == null) {
            retJson.put("code","9997");
            return retJson;
        }
        String code = "";
        String result = signService.signIn(tbluAccount);
        switch (result) {
            case "1":
                code = "0000";
                break;
            case "-1":
                code = "1001";
                break;
            case "-2":
                code = "1002";
                break;
            case "-3":
                code = "1003";
                break;
        }
        retJson.put("code", code);
        return retJson;
    }
}
