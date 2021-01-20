package com.jzxy.springcloud.service.impl;

import com.jzxy.springcloud.dao.PaymentDao;
import com.jzxy.springcloud.entities.Payment;
import com.jzxy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zch
 * @Date 2020/12/30 17:45
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
