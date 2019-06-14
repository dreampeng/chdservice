package com.apesing.chd.service.impl;

import com.apesing.chd.entity.TbluAccount;
import com.apesing.chd.mapper.AccountMapper;
import com.apesing.chd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户接口
 **/
@Service
public class AccountServiceImp implements AccountService {

    private AccountMapper accountMapper;

    @Autowired
    public AccountServiceImp(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }


    @Override
    public TbluAccount getAccountById(String id) {
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        List<TbluAccount> tbluAccounts = accountMapper.selectByMap(param);
        if (tbluAccounts.size() > 0) {
            return tbluAccounts.get(0);
        }
        return null;
    }

    @Override
    public TbluAccount getAccountByUid(String uid) {
        Map<String, Object> param = new HashMap<>();
        param.put("uid", uid);
        List<TbluAccount> tbluAccounts = accountMapper.selectByMap(param);
        if (tbluAccounts.size() > 0) {
            return tbluAccounts.get(0);
        }
        return null;
    }

    @Override
    public TbluAccount getAccountByNickName(String nickName) {
        Map<String, Object> param = new HashMap<>();
        param.put("NickName", nickName);
        List<TbluAccount> tbluAccounts = accountMapper.selectByMap(param);
        if (tbluAccounts.size() > 0) {
            return tbluAccounts.get(0);
        }
        return null;
    }

    @Override
    public TbluAccount getAccountByMail(String mail) {
        Map<String, Object> param = new HashMap<>();
        param.put("mail", mail);
        List<TbluAccount> tbluAccounts = accountMapper.selectByMap(param);
        if (tbluAccounts.size() > 0) {
            return tbluAccounts.get(0);
        }
        return null;
    }

    @Override
    public List<TbluAccount> getAccountByParam(Map<String, Object> param) {
        return accountMapper.selectByMap(param);
    }

    @Override
    public void addAccount(String userName, String passWord, String mail) {
        TbluAccount account = new TbluAccount();
        account.setCreatedtime(new Date());
        account.setMail(mail);
        account.setId(userName);
        account.setPw(passWord);
//        account.setUid(3);
        accountMapper.insertAccount(account);
    }
}
