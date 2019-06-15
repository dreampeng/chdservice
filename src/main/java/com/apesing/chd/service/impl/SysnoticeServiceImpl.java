package com.apesing.chd.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.apesing.chd.entity.Sysnotice;
import com.apesing.chd.mapper.SysnoticeMapper;
import com.apesing.chd.service.SysnoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class SysnoticeServiceImpl implements SysnoticeService {
    private final SysnoticeMapper sysnoticeMapper;

    @Autowired
    public SysnoticeServiceImpl(SysnoticeMapper sysnoticeMapper) {
        this.sysnoticeMapper = sysnoticeMapper;
    }

    @Override
    public JSONObject getNotice(String type, Date endTime) {
        Map<String, Object> param = new HashMap<>();
        //param.put("type", type);
        List<Sysnotice> sysnotices = sysnoticeMapper.selectByMap(param);
        JSONObject notices = new JSONObject();
        sysnotices.forEach(e -> {
            List<String> tempStrs = (List<String>) notices.get(e.getType());
            if (tempStrs == null) {
                tempStrs = new ArrayList<>();
            }
            tempStrs.add(e.getNotice());
            notices.put(e.getType(), tempStrs);
        });
        return notices;
    }
}
