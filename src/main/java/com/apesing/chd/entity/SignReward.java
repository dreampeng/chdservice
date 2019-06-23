package com.apesing.chd.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * CREATE TABLE [dbo].[z_lun_signreword] (
 * [id] varchar(32) NOT NULL,
 * [year] varchar(4) NOT NULL,
 * [month] varchar(2) NOT NULL,
 * [day] varchar(2) NOT NULL,
 * [itemid] varchar(32) NOT NULL,
 * [contype] varchar(2) NULL,
 * [count] int NOT NULL,
 * PRIMARY KEY CLUSTERED ([id])
 * WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
 * )
 */
@TableName("z_lun_signreward")
public class SignReward {

    @TableId
    private String id;
    private String year;
    private String month;
    private String day;
    private String itemid;
    private String contype;
    private String count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getContype() {
        return contype;
    }

    public void setContype(String contype) {
        this.contype = contype;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
