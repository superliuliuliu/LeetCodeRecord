package com.designpattern.structual.proxy;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2019/12/8 22:21
 */
public class OrderServiceImpl implements IOrderService {

    private IOrderMapper iOrderMapper;

    @Override
    public int saveOrder(Order order) {
        iOrderMapper = new OrderMapper();
        System.out.println("service层调用mapper创建订单");
        return iOrderMapper.insert(order);
    }
}
