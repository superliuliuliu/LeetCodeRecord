package com.designpattern.structual.proxy.staticproxy;

import com.designpattern.structual.proxy.IOrderService;
import com.designpattern.structual.proxy.Order;
import com.designpattern.structual.proxy.OrderServiceImpl;
import com.designpattern.structual.proxy.db.DataSourceContextHolder;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 订单service静态代理类
 * @date 2019/12/8 22:27
 */
public class OrderServiceStaticProxy {

    private IOrderService iOrderService;

    public int saveOrder(Order order){
        beforeMethod(order);
        iOrderService = new OrderServiceImpl();
        int result = iOrderService.saveOrder(order);
        afterMethod();
        return result;

    }

    private void beforeMethod(Order order){
        System.out.println("静态代理 before方法");
        // 对userId做奇偶数判定
        int dbRouter = order.getUserId() & 1;
        System.out.println("静态代理分配到：" + dbRouter + "处理数据");
        // 设置数据源
        DataSourceContextHolder.setDBtype(String.valueOf(dbRouter));
    }

    private void afterMethod(){
        System.out.println("静态代理 after方法");
    }
}
