package com.apesing.chd.service;

import com.apesing.chd.entity.TbluAccount;

import java.util.List;
import java.util.Map;

/**
 * 用户接口
 */
public interface AccountService {

    //登录
    TbluAccount userLogin(String name, String pass);

    //根据账号获取用户
    TbluAccount getAccountById(String id);

    //根据uid获取用户
    TbluAccount getAccountByUid(String uid);

    //根据NickName获取用户
    TbluAccount getAccountByNickName(String nickName);

    //根据邮箱获取用户
    TbluAccount getAccountByMail(String mail);

    //根据传入参数获取用户
    List<TbluAccount> getAccountByParam(Map<String, Object> param);

    //新增用户
    void addAccount(String userName, String passWord, String mail);
}
