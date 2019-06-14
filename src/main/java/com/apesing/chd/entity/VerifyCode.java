package com.apesing.chd.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * CREATE TABLE [dbo].[verifycode] (
 * [id] varchar(32) COLLATE Chinese_PRC_CI_AS NOT NULL,
 * [addr] varchar(255) COLLATE Chinese_PRC_CI_AS NOT NULL,
 * [code] varchar(32) COLLATE Chinese_PRC_CI_AS NOT NULL,
 * [type] varchar(2) COLLATE Chinese_PRC_CI_AS NOT NULL,
 * [createtime] datetime NOT NULL,
 * [createtime] datetime ,
 * [isuse] varchar(2) COLLATE Chinese_PRC_CI_AS NOT NULL,
 * PRIMARY KEY CLUSTERED ([id])
 * WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = OFF, ALLOW_PAGE_LOCKS = OFF)
 * )
 */
@TableName("verifycode")
public class VerifyCode {
    @TableId
    private String id;//主键
    private String addr;//地址
    private String code;//验证码
    private String type;//类型
    private Date createtime;//创建时间
    private String isuse;//是否已使用
    private Date usetime;//使用时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIsuse() {
        return isuse;
    }

    public void setIsuse(String isuse) {
        this.isuse = isuse;
    }

    public Date getUsetime() {
        return usetime;
    }

    public void setUsetime(Date usetime) {
        this.usetime = usetime;
    }
}
