package com.jzxy.springcloud.service;

import com.jzxy.springcloud.domain.Order;

public interface OrderService {
    //创建订单
    void create(Order order);
}
