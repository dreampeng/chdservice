package com.apesing.chd.service.impl;

import com.apesing.chd.MyMailService;
import com.apesing.chd.entity.VerifyCode;
import com.apesing.chd.mapper.VerifyMapper;
import com.apesing.chd.service.VerifyCodeService;
import com.apesing.chd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 **/
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    private VerifyMapper verifyMapper;
    private MyMailService myMailService;

    @Autowired
    public VerifyCodeServiceImpl(VerifyMapper verifyMapper,MyMailService myMailService) {
        this.verifyMapper = verifyMapper;
        this.myMailService = myMailService;
    }

    @Override
    public void sendMailCode(String mail, String type) {
        VerifyCode verifyCode = getByAddrAndType(mail, type);
        String code;
        if (verifyCode == null) {
            code = StringUtil.getRandomStr(5);
            verifyCode = new VerifyCode();
            verifyCode.setId(StringUtil.getUuid());
            verifyCode.setCreatetime(new Date());
            verifyCode.setCode(code);
            verifyCode.setIsuse("0");
            verifyCode.setAddr(mail);
            verifyCode.setType(type);
        } else {
            code = verifyCode.getCode();
        }
        myMailService.sendSimpleMail(mail, "您收到一份邮箱密令", "您收到的邮箱密令为：" + code);
    }

    @Override
    public boolean verifyCode(String addr, String code, String type) {
        VerifyCode verifyCode = getByAddrAndType(addr, type);
        if (verifyCode.getCode().equals(code)) {
            verifyCode.setIsuse("1");
            verifyCode.setUsetime(new Date());
            verifyMapper.updateById(verifyCode);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public VerifyCode getByAddrAndType(String addr, String type) {
        Map<String, Object> param = new HashMap<>();
        param.put("addr", addr);
        param.put("type", type);
        param.put("isuse", "0");
        List<VerifyCode> verifyCodes = verifyMapper.selectByMap(param);
        if (verifyCodes.size() == 1) {
            return verifyCodes.get(0);
        }
        return null;
    }
}
