package com.jzxy.MyRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/9 21:08
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        // 定义为随机规则
        return new RandomRule();
    }
}
