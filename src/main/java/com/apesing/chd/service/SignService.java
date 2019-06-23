package com.apesing.chd.service;

import com.alibaba.fastjson.JSONArray;

public interface SignService {
    JSONArray getSignList(String year, String month);

    String signIn(String uid);

    JSONArray getSignedList(String year, String month);
}
