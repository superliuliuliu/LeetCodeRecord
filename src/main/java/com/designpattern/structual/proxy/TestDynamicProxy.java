package com.designpattern.structual.proxy;

import com.designpattern.structual.proxy.dynamicproxy.OrderServiceDynamicProxy;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 测试动态代理
 * @date 2019/12/9 11:15
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);
        IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderService.saveOrder(order);
    }
}
