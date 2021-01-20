package com.jzxy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/15 10:11
 */
@RestController
public class OrderNacosController {
    //private static final String SERVICE_URL = "http://nacos-payment-provider";
    @Value("${service-uri.nacos-user-service}") // 配置与代码分离
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        String result = restTemplate.getForObject(serverURL + "/payment/nacos/" + id,String.class);
        return result;
    }
}
