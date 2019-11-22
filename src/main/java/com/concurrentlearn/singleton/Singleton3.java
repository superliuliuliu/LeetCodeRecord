package com.concurrentlearn.singleton;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 懒汉式获取单例 优点需要时才加载 缺点线程不安全
 * @date 2019/11/7 12:46
 */
public class Singleton3 {
    private static Singleton3 instance;

    public static Singleton3 getInstance(){
        if (instance == null){
            return new Singleton3();
        }
        return instance;
    }
}
