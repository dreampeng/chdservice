package com.apesing.chd.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.apesing.chd.entity.SignRecord;
import com.apesing.chd.entity.SignReward;
import com.apesing.chd.entity.TbluAccount;
import com.apesing.chd.mapper.DataUse;
import com.apesing.chd.mapper.SignRecordMapper;
import com.apesing.chd.mapper.SignRewardMapper;
import com.apesing.chd.mapper.TbluItemMapper;
import com.apesing.chd.service.SignService;
import com.apesing.chd.util.StringUtil;
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

    private final TbluItemMapper tbluItemMapper;

    private final DataUse dataUse;

    @Autowired
    public SignServiceImpl(SignRecordMapper recordMapper, SignRewardMapper rewardMapper, TbluItemMapper tbluItemMapper, DataUse dataUse) {
        this.recordMapper = recordMapper;
        this.rewardMapper = rewardMapper;
        this.tbluItemMapper = tbluItemMapper;
        this.dataUse = dataUse;
    }


    @Override
    public JSONArray getSignList(String year, String month) {
        dataUse.useAccount();
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
    @Transactional
    public String signIn(TbluAccount tbluAccount) {
        Map<String, Object> param = new HashMap<>();
        String year = Integer.toString(TimeUtil.getYear(new Date()));
        String month = Integer.toString(TimeUtil.getMonth(new Date()));
        String day = Integer.toString(TimeUtil.getDay(new Date()));
        param.put("year", year);
        param.put("month", month);
        param.put("day", day);
        param.put("uid", tbluAccount.getId());
        List<SignRecord> recordList = recordMapper.selectByMap(param);
        List<Map<String, Object>> items = tbluItemMapper.getListByUidAndType(tbluAccount.getUid(), 9);
        if (items.size() < 1) {
            return "-3";
        }
        //仓库第一格被使用
        for (Map<String, Object> item : items) {
            if ("1".equals(item.get("containerslot").toString())) {
                return "-2";
            }
        }
        param = new HashMap<>();
        param.put("year", year);
        param.put("month", month);
        param.put("day", day);
        dataUse.useAccount();
        List<SignReward> rewardList = rewardMapper.selectByMap(param);
        if (recordList.size() < 1) {
            SignRecord signRecord = new SignRecord();
            signRecord.setId(StringUtil.getUuid());
            signRecord.setUid(tbluAccount.getId());
            signRecord.setCreatetime(new Date());
            signRecord.setYear(year);
            signRecord.setMonth(month);
            signRecord.setDay(day);
            recordMapper.insert(signRecord);
            param = new HashMap<>();
            param.put("uid", tbluAccount.getUid());
            param.put("charid", items.get(0).get("charid"));
            param.put("containertype", rewardList.get(0).getContype());
            param.put("containerslot", 1);
            param.put("typeid", rewardList.get(0).getItemid());//////////////////////
            param.put("cnt", rewardList.get(0).getCount());///////////////
            param.put("rare", 1);
            tbluItemMapper.insert(param);
            return "1";
        }
        return "-1";
    }

    @Override
    public List<String> getSignedList(String year, String month, String uid) {
        dataUse.useAccount();
        Map<String, Object> param = new HashMap<>();
        param.put("year", year);
        param.put("month", month);
        param.put("uid", uid);
        List<String> recordArray = new ArrayList<>();
        List<SignRecord> recordList = recordMapper.selectByMap(param);
        recordList.forEach(record -> recordArray.add(record.getDay()));
        return recordArray;
    }
}
