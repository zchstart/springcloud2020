package com.jzxy.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 17:33
 */
@Mapper
public interface AccountDao {
    //扣钱
    void decrease(@Param("userId") Long userId,@Param("money") BigDecimal money);
}
