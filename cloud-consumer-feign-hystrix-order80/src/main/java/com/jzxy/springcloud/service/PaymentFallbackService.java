package com.jzxy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/11 10:55
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---PaymentFallbackService-paymentInfo_OK fall back -_-";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---PaymentFallbackService-paymentInfo_TimeOut fall back -_-";
    }
}
