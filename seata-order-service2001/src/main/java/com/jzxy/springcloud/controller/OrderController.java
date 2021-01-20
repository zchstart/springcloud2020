package com.jzxy.springcloud.controller;

import com.jzxy.springcloud.domain.CommonResult;
import com.jzxy.springcloud.domain.Order;
import com.jzxy.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 16:38
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
