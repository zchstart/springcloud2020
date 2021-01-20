package com.jzxy.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/10 18:20
 */
@Service
public class PaymentService {
    //正常访问
    public String paymentInfo_OK(Integer id){
        return "线程：" + Thread.currentThread().getName() + "paymentInfo_OK，id：" + id;
    }
    //超时访问
    //为了测试订单服务降级，修改为可以正常运行的状态
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    }) //规定3秒为正常运行时间
    public String paymentInfo_TimeOut(Integer id){
        //int age = 10 / 0;
        //睡3秒
        int timeout = 3;
        try { TimeUnit.SECONDS.sleep(timeout); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程：" + Thread.currentThread().getName() + "paymentInfo_TimeOut，id：" + id;
    }
    //兜底方法
    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id) {
        return "线程：" + Thread.currentThread().getName() + "8001系统繁忙或运行出错，id：" + id;
    }

    //-------服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("***id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功，流水号：" + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍候再试-_-~     id：" + id;
    }

}
