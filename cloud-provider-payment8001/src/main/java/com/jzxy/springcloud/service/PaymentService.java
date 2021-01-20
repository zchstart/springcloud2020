package com.jzxy.springcloud.service;

import com.jzxy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author zch
 * @Date 2020/12/30 17:44
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
