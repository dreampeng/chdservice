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
}
