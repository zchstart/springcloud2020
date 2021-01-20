package com.jzxy.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 17:33
 */
@Mapper
public interface StorageDao {
    //减库存
    void decrease(@Param("productId") Long productId,@Param("count")Integer count);
}
