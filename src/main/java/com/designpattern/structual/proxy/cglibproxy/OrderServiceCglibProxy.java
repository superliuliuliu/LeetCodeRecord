package com.designpattern.structual.proxy.cglibproxy;

import com.designpattern.structual.proxy.Order;
import com.designpattern.structual.proxy.db.DataSourceContextHolder;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 基于Cglib的动态代理
 * @date 2019/12/9 14:00
 */
public class OrderServiceCglibProxy implements MethodInterceptor {

    // 被代理的目标对象
    private Object target;

    // 构造函数传入目标对象
    public OrderServiceCglibProxy(Object target){
        this.target = target;
    }

    public Object bind(){
        Enhancer enhancer = new Enhancer();
        // cglib是基于继承实现的动态代理 所以设置其父类的class
        enhancer.setSuperclass(target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 返回动态生成的代理对象
        return enhancer.create();
    }

    /**
     * intercept
     * @description 实现MethodInterceptor接口的方法
     * @param o 生成的代理对象
     * @param method 代理对象的方法
     * @param objects 代理对象方法的执行参数
     * @param methodProxy 方法代理
     * @return {@link }
     * @author liugaoyang
     * @date 2019/12/9 14:09
     * @version 1.0.0
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 获取方法参数
        Object args = objects[0];
        beforeMethod(args);
        Object result = methodProxy.invokeSuper(o, objects);
        afterMethod();
        return result;
    }

    private void beforeMethod(Object obj){
        System.out.println("cglib动态代理 before方法");
        int userId = 0;
        if (obj instanceof Order){
            Order order = (Order) obj;
            userId = order.getUserId();
        }
        // 还可以增加处理目标对象 体现了动态代理的作用
//        else if (){
//
//        }
        // 对userId做奇偶数判定
        int dbRouter = userId & 1;
        System.out.println("cglib动态代理分配到：" + dbRouter + "处理数据");
        // 设置数据源
        DataSourceContextHolder.setDBtype(String.valueOf(dbRouter));
    }

    private void afterMethod(){
        System.out.println("cglib动态代理 after方法");

    }
}
