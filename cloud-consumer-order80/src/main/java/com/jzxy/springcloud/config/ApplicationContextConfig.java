package com.jzxy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author zch
 * @Date 2020/12/30 22:47
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //使用自定义的负载均衡
    //@LoadBalanced // 开启负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
