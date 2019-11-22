package com.concurrentlearn.singleton;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 饿汉式单例模式（静态常量）
 * @date 2019/11/7 12:20
 */
public class Singleton1 {

    public final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){
    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
