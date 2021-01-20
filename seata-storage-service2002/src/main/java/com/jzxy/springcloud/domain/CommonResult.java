package com.jzxy.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description json封装体
 * @Author zch
 * @Date 2020/12/30 16:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    // 404 not_found
    private Integer id;
    private String message;
    private T data;

    public CommonResult(Integer id, String message){
        this(id,message,null);
    }
}
