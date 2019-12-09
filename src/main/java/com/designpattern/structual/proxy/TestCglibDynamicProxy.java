package com.designpattern.structual.proxy;

import com.designpattern.structual.proxy.cglibproxy.OrderServiceCglibProxy;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 测试基于cglib的动态代理
 * @date 2019/12/9 14:18
 */
public class TestCglibDynamicProxy {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(10);
        IOrderService orderService = (IOrderService) new OrderServiceCglibProxy(new OrderServiceImpl()).bind();
        orderService.saveOrder(order);
    }
}
