package com.apesing.chd.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * 公告相关
 */
public interface SysnoticeService {
    /**
     * 获取公告
     *
     * @param type    类型
     * @param endTime 结束时间
     * @return 公告
     */
    JSONObject getNotice(String type, Date endTime);
}
