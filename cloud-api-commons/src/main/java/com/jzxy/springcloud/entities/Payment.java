package com.jzxy.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author zch
 * @Date 2020/12/30 16:35
 */
@Data //生成getter,setter等函数
@NoArgsConstructor //生成无参构造函数
@AllArgsConstructor //生成全参数构造函数
public class Payment implements Serializable {
    private Long id; //数据库中id字段类型为 bigint(20)
    private String serial;
}