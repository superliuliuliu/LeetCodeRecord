package com.designpattern.structual.proxy.dynamicproxy;

import com.designpattern.structual.proxy.Order;
import com.designpattern.structual.proxy.db.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 动态代理
 * @date 2019/12/9 0:19
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    // 目标对象
    private Object target;

    // 构造器
    public OrderServiceDynamicProxy(Object target){
        this.target = target;
    }

    // 返回动态代理生成的对象
    public Object bind(){
        Class clazz = target.getClass();
        // 返回一个新的代理实例 方法如下 参数依次为目标对象的类加载器、目标对象实现的接口、InvocationHandler本身
        //  public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }
    /**
     * invoke
     * @description
     * @param proxy 生成的代理对象  以便获取生成的代理对象的方法和参数
     * @param method 要增强的方法
     * @param args 增强方法的参数
     * @return {@link }
     * @author liugaoyang
     * @date 2019/12/9 10:58
     * @version 1.0.0
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取方法的参数
        Object argObject = args[0];
        // 执行方法增强
        beforeMethod(argObject);
        // 利用反射执行目标对象的方法
        Object object = method.invoke(target, argObject);
        // 执行方法增强
        afterMethod();
        // 返回目标对象方法的返回值
        return object;
    }

    private void beforeMethod(Object obj){
        System.out.println("JDK动态代理 before方法");
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
        System.out.println("JDK动态代理分配到：" + dbRouter + "处理数据");
        // 设置数据源
        DataSourceContextHolder.setDBtype(String.valueOf(dbRouter));
    }

    private void afterMethod(){
        System.out.println("JDK动态代理 after方法");

    }
}
