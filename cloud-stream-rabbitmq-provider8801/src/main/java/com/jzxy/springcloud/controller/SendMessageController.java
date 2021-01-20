package com.jzxy.springcloud.controller;

import com.jzxy.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/14 14:01
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String SendMessage(){
        return messageProvider.send();
    }
}
