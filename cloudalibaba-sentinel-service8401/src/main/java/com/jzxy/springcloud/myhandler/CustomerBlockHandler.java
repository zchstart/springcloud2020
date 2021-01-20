package com.jzxy.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jzxy.springcloud.entities.CommonResult;
import com.jzxy.springcloud.entities.Payment;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/17 21:28
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(444,"按客户自定义，global_handlerException---1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义，global_handlerException---2");
    }
}
