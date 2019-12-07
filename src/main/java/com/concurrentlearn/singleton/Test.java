package com.concurrentlearn.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 单例模式测试类之反射破坏
 * @date 2019/12/7 9:38
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 通过单例模式的接口获取单例
        Singleton6 instance = Singleton6.getInstance();
        Class objectClass = Singleton6.class;
        // 通过反射获取构造器
        Constructor constructor = objectClass.getDeclaredConstructor();
        // 设置权限 可以获取私有属性与方法
        constructor.setAccessible(true);
        Singleton6 newInstance = (Singleton6) constructor.newInstance();
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}
