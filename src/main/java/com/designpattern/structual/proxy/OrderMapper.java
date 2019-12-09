package com.designpattern.structual.proxy;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2019/12/8 22:19
 */
public class OrderMapper implements IOrderMapper {

    @Override
    public int insert(Order order) {
        System.out.println("数据库插入订单对象");
        return 1;
    }
}
