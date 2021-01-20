package com.jzxy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/10 11:29
 */
@SpringBootApplication
@EnableFeignClients //开启 Feigen
public class OrderFeigenMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeigenMain80.class,args);
    }
}
