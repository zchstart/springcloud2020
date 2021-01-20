package com.jzxy.springcloud.service.impl;

import com.jzxy.springcloud.dao.AccountDao;
import com.jzxy.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 16:18
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    //扣钱
    @Override
    public void decrease(Long productId, BigDecimal money) {
        //模拟超时异常，全局事务回滚
        //int timeout = 20;
        //try { TimeUnit.SECONDS.sleep(timeout); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("---->订单微服务开始调用库存，做扣减Count");
        accountDao.decrease(productId, money);
        log.info("执行完成");
    }
}