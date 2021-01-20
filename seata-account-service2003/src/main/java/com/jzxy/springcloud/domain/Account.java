package com.jzxy.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/18 17:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private Long userId;
    //总额度
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
