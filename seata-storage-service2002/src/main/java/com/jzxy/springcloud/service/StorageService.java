package com.jzxy.springcloud.service;

import com.jzxy.springcloud.domain.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 16:17
 */
public interface StorageService {
    void decrease(Long productId,Integer count);
}
