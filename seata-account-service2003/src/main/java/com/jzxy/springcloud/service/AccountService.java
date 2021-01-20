package com.jzxy.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 16:17
 */
public interface AccountService {
    void decrease(Long productId,BigDecimal money);
}
