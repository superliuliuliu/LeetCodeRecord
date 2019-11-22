package com.concurrentlearn.singleton;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 懒汉式获取单例 优点需要时才加载 缺点虽然保证了线程安全 但是效率低下 一次只能有一个线程获取
 * @date 2019/11/7 12:46
 */
public class Singleton4 {
    private static Singleton4 instance;

    public static synchronized Singleton4 getInstance(){
        if (instance == null){
            return new Singleton4();
        }
        return instance;
    }
}
