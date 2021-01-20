package com.jzxy.springcloud.service.impl;

import com.jzxy.springcloud.dao.OrderDao;
import com.jzxy.springcloud.domain.Order;
import com.jzxy.springcloud.service.AccountService;
import com.jzxy.springcloud.service.OrderService;
import com.jzxy.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 16:18
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    //下订单->减库存->扣余额->改（订单）状态
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("---->开始新建订单");
        orderDao.create(order);

        log.info("---->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("---->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());

        log.info("修改订单状态");
        //mapper中把传入的status改为 1
        orderDao.update(order.getUserId(),0);
    }
}
