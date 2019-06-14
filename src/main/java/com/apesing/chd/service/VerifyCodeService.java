package com.apesing.chd.service;

import com.apesing.chd.entity.VerifyCode;

/**
 *
 *
 **/
public interface VerifyCodeService {
    /**
     * 发送邮箱密令
     *
     * @param mail 接受地址
     * @param type 类型
     */
    void sendMailCode(String mail, String type);

    /**
     * 验证密令
     *
     * @param addr 地址
     * @param code 密令
     * @param type 类型
     * @return 是否正确
     */
    boolean verifyCode(String addr, String code, String type);

    /**
     * 获取密令
     * @param addr 地址
     * @return 密令
     */
    VerifyCode getByAddrAndType(String addr,String type);
}
