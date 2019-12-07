package com.concurrentlearn.singleton;

import java.util.Date;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 线程本地存储之单例模式
 * @date 2019/12/7 13:54
 */
public class ThreadlocalSingleton {

    private static ThreadLocal<ThreadlocalSingleton> instance = new ThreadLocal<ThreadlocalSingleton>(){
        @Override
        protected ThreadlocalSingleton initialValue() {
            return new ThreadlocalSingleton();
        }
    };

    private ThreadlocalSingleton(){

    }

    public static ThreadlocalSingleton getInstance(){
        return instance.get();
    }

    public static void main(String[] args) {

    }

}
