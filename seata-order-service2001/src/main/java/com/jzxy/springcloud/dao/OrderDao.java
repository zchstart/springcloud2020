package com.jzxy.springcloud.dao;

import com.jzxy.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 15:47
 */
@Mapper
public interface OrderDao {

    //新建订单
    void create(Order order);

    //修改订单状态，从 0 改为 1
    void update(@Param("userId") Long userId,@Param("status") Integer status);

}
