package com.jzxy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/17 15:31
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "----testA";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName() + "......testB");
        return "----testB";
    }

    @GetMapping("/testD")
    public String testD(){
//        int timeout = 1;
//        try { TimeUnit.SECONDS.sleep(timeout); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("test  RT");
        log.info("test 异常比例");
        int age = 10 / 0;
        return "----testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("test 异常数");
        int age = 10 / 0;
        return "----testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey1",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "----testHotKey";
    }
    //兜底方法
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "----deal_testHotKey"; //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }
}
