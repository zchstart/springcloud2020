package com.jzxy.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/10 14:47
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        //设置 Feign 日志级别为 Full
        return Logger.Level.FULL;
    }
}
