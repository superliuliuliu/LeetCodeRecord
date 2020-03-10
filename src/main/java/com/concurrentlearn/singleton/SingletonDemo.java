package com.concurrentlearn.singleton;

import java.io.Serializable;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 包含最多知识点的单例模式
 * @date 2020/2/26 20:29
 */
public class SingletonDemo implements Serializable {

    private volatile static SingletonDemo INSTANCE;

    private SingletonDemo() {
    }

    /*基与volatile 关键字实现的双检锁单例模式*/
    public static SingletonDemo getInstance(){
        if (INSTANCE==null){
            synchronized (SingletonDemo.class){
                if (INSTANCE == null){
                    INSTANCE = new SingletonDemo();
                }
            }
        }
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
