package com.concurrentlearn.singleton;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 基于静态内部类的单例模式
 * @date 2019/11/7 12:46
 */
public class Singleton7 {

    static class SingletonInstance{
        private static Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
