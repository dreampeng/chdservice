package com.apesing.chd.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigInteger;
import java.util.Date;

/**
 * 用户表
 **/
@TableName("TbluAccount")
public class TbluAccount {
    private int UID;//uid
    private String ID;//用户名
    private String PW;//密码
    private String mail;//邮箱
    private Date latestLoginTime;//最后登录时间
    private int failedLoginTimes;//登录失败次数
    private Date createdTime;//创建时间
    private int Block;//是否锁定
    private String Name;//实名认证
    private String SSN;//身份证
    private int Gender;//性别
    private String NickName;//昵称
    private BigInteger DigitID;//
    private Date BlockTime;//锁定时间
    private String ip;//ip
    private int tid;
    private int ElaspedMin;
    private int IsOnlineStatus;

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(Date latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    public int getFailedLoginTimes() {
        return failedLoginTimes;
    }

    public void setFailedLoginTimes(int failedLoginTimes) {
        this.failedLoginTimes = failedLoginTimes;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getBlock() {
        return Block;
    }

    public void setBlock(int block) {
        Block = block;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public BigInteger getDigitID() {
        return DigitID;
    }

    public void setDigitID(BigInteger digitID) {
        DigitID = digitID;
    }

    public Date getBlockTime() {
        return BlockTime;
    }

    public void setBlockTime(Date blockTime) {
        BlockTime = blockTime;
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

    public int getElaspedMin() {
        return ElaspedMin;
    }

    public void setElaspedMin(int elaspedMin) {
        ElaspedMin = elaspedMin;
    }

    public int getIsOnlineStatus() {
        return IsOnlineStatus;
    }

    public void setIsOnlineStatus(int isOnlineStatus) {
        IsOnlineStatus = isOnlineStatus;
    }
}
