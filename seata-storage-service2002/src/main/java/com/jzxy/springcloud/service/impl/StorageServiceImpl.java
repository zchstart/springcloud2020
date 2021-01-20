package com.jzxy.springcloud.service.impl;

import com.jzxy.springcloud.dao.StorageDao;
import com.jzxy.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 16:18
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    //减库存
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("---->订单微服务开始调用库存，做扣减Count");
        storageDao.decrease(productId, count);
    }
}
