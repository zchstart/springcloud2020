package com.jzxy.springcloud.service;

import com.jzxy.springcloud.entities.CommonResult;
import com.jzxy.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 10:43
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444444,"服务降级返回，PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
