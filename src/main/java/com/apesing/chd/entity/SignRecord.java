package com.apesing.chd.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * CREATE TABLE [dbo].[z_lun_signrecord] (
 * [id] varchar NOT NULL,
 * [uid] varchar(32) NOT NULL,
 * [cid] varchar(32) NULL,
 * [signdate] datetime NOT NULL,
 * PRIMARY KEY CLUSTERED ([id])
 * WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
 * )
 */
@TableName("z_lun_signrecord")
public class SignRecord {
    @TableId
    private String id;
    private String uid;
    private String cid;
    private Date signdate;

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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }
}
