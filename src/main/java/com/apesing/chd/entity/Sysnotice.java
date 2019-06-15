package com.apesing.chd.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * CREATE TABLE [dbo].[z_lun_sysnotice] (
 * [id] varchar(32) NOT NULL,
 * [type] varchar(32) NOT NULL,
 * [notice] varchar(255) NOT NULL,
 * [sort] int NOT NULL,
 * [createtime] datetime NOT NULL,
 * [endtime] datetime,
 * PRIMARY KEY CLUSTERED ([id])
 * WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
 * )
 */
@TableName("z_lun_sysnotice")
public class Sysnotice {
    @TableId
    private String id;
    private String type;
    private String notice;
    private int sort;
    private Date createtime;
    private Date endtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
