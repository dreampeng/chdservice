package com.apesing.chd.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.apesing.chd.entity.SignRecord;
import com.apesing.chd.entity.SignReward;
import com.apesing.chd.mapper.SignRecordMapper;
import com.apesing.chd.mapper.SignRewardMapper;
import com.apesing.chd.service.SignService;
import com.apesing.chd.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class SignServiceImpl implements SignService {

    private final SignRecordMapper recordMapper;

    private final SignRewardMapper rewardMapper;

    @Autowired
    public SignServiceImpl(SignRecordMapper recordMapper, SignRewardMapper rewardMapper) {
        this.recordMapper = recordMapper;
        this.rewardMapper = rewardMapper;
    }


    @Override
    public JSONArray getSignList(String year, String month) {
        Map<String, Object> param = new HashMap<>();
        param.put("year", year);
        param.put("month", month);
        JSONArray rewardArray = new JSONArray();
        List<SignReward> rewardList = rewardMapper.selectByMap(param);
        rewardList.forEach(reward -> {
            JSONObject temp = new JSONObject();
            temp.put("id", reward.getId());
            temp.put("year", reward.getYear());
            temp.put("month", reward.getMonth());
            temp.put("day", reward.getDay());
            temp.put("itemid", reward.getItemid());
            temp.put("contype", reward.getContype());
            temp.put("count", reward.getCount());
            rewardArray.add(temp);
        });
        return rewardArray;
    }

    @Override
    public String signIn(String uid) {
        return null;
    }

    @Override
    public JSONArray getSignedList(String year, String month) {
        Map<String, Object> param = new HashMap<>();
        param.put("year", year);
        param.put("month", month);
        JSONArray recordArray = new JSONArray();
        List<SignRecord> recordList = recordMapper.selectByMap(param);
        recordList.forEach(record -> {
            JSONObject temp = new JSONObject();
            Date date = record.getSigndate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            temp.put("year", calendar.get(Calendar.YEAR));
            temp.put("month", calendar.get(Calendar.MONTH) + 1);
            temp.put("day", calendar.get(Calendar.DAY_OF_MONTH));
            temp.put("week", TimeUtil.getWeek(date));
            recordArray.add(temp);
        });
        return recordArray;
    }
}
