package com.jzxy.springcloud.controller;

import com.jzxy.springcloud.entities.CommonResult;
import com.jzxy.springcloud.entities.Payment;
import com.jzxy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private DiscoveryClient discoveryClient;

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

    //iter 迭代器 iterate
    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获得服务列表
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            log.info("***element:" + service);
        }
        //获得指定服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instances){
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + instance.getPort() + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentTimeOut() {
        //暂停三秒线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi , i am paymentZipkin server fall back , welcome to jzxy , -_-";
    }
}
