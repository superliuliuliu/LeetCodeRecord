package com.designpattern.structual.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 订单
 * @date 2019/12/8 21:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private String id;

    private String name;

    private Integer userId;

}
