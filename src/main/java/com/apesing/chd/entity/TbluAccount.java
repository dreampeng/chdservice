package com.apesing.chd.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigInteger;
import java.util.Date;

/**
 * 用户表
 **/
@TableName("TbluAccount")
public class TbluAccount {
    @TableId
    private int uid;//uid
    private String id;//用户名
    private String pw;//密码
    private String mail;//邮箱
    private Date latestlogintime;//最后登录时间
    private int failedlogintimes;//登录失败次数
    private Date createdtime;//创建时间
    private int block;//是否锁定
    private String name;//实名认证
    private String ssn;//身份证
    private int gender;//性别
    private String nickname;//昵称
    private BigInteger digitid;//
    private Date blocktime;//锁定时间
    private String ip;//ip
    private int tid;
    private int elaspedmin;
    private int isonlinestatus;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getLatestlogintime() {
        return latestlogintime;
    }

    public void setLatestlogintime(Date latestlogintime) {
        this.latestlogintime = latestlogintime;
    }

    public int getFailedlogintimes() {
        return failedlogintimes;
    }

    public void setFailedlogintimes(int failedlogintimes) {
        this.failedlogintimes = failedlogintimes;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public BigInteger getDigitid() {
        return digitid;
    }

    public void setDigitid(BigInteger digitid) {
        this.digitid = digitid;
    }

    public Date getBlocktime() {
        return blocktime;
    }

    public void setBlocktime(Date blocktime) {
        this.blocktime = blocktime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getElaspedmin() {
        return elaspedmin;
    }

    public void setElaspedmin(int elaspedmin) {
        this.elaspedmin = elaspedmin;
    }

    public int getIsonlinestatus() {
        return isonlinestatus;
    }

    public void setIsonlinestatus(int isonlinestatus) {
        this.isonlinestatus = isonlinestatus;
    }
}
