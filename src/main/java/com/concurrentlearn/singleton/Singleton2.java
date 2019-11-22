package com.concurrentlearn.singleton;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 饿汉式加载静态代码块形式
 * @date 2019/11/7 12:36
 */
public class Singleton2 {

    public final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
