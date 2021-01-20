package com.jzxy.springcloud.controller;

import com.jzxy.springcloud.entities.CommonResult;
import com.jzxy.springcloud.entities.Payment;
import com.jzxy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zch
 * @Date 2020/12/30 19:12
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if (result > 0){
            return new CommonResult(200,"插入成功,serverport:" + serverPort, payment);
        }else{
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果" + payment);

        if (payment != null){
            return new CommonResult(200,"查询成功,serverport:" + serverPort,payment);
        }else{
            return new CommonResult(444,"查询失败，ID：" + id,null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
