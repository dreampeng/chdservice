package com.apesing.chd.service;

import com.alibaba.fastjson.JSONArray;
import com.apesing.chd.entity.TbluAccount;

import java.util.List;

public interface SignService {
    JSONArray getSignList(String year, String month);

    String signIn(TbluAccount uid);

    List<String> getSignedList(String year, String month, String uid);
}
