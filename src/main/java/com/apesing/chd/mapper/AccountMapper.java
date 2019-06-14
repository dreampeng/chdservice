package com.apesing.chd.mapper;

import com.apesing.chd.entity.TbluAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 账号相关
 */
public interface AccountMapper extends BaseMapper<TbluAccount> {
    @Insert("use dbLataleAccount insert into TbluAccount (id,pw,mail,createdtime)" +
            " values (#{account.id},#{account.pw},#{account.mail},#{account.createdtime})")
    void insertAccount(@Param("account") TbluAccount account);
}
