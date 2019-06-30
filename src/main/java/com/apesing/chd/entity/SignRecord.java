package com.apesing.chd.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;


/**
 * CREATE TABLE [dbo].[z_lun_signrecord] (
 * [id] varchar(32) NOT NULL,
 * [uid] varchar(32) NOT NULL,
 * [year] varchar(4) COLLATE Chinese_PRC_CI_AS  NOT NULL,
 * [month] varchar(2) COLLATE Chinese_PRC_CI_AS  NOT NULL,
 * [day] varchar(2) COLLATE Chinese_PRC_CI_AS  NOT NULL,
 * [createtime] datetime NOT NULL,
 * PRIMARY KEY CLUSTERED ([id])
 * WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
 * )
 */
@TableName("z_lun_signrecord")
public class SignRecord {
    @TableId
    private String id;
    private String uid;
    private String year;
    private String month;
    private String day;
    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
