package com.jzxy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 16:44
 */
@Configuration
@MapperScan("com.jzxy.springcloud.dao")
public class MyBatisConfig {
}
