package com.concurrentlearn.singleton;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 双检锁式单例模式 解决重排序带来的空指针异常问题
 * @date 2019/11/7 12:46
 */
public class Singleton6 {
    private static volatile Singleton6 instance;

    public static Singleton6 getInstance(){
        if (instance == null){
            synchronized (Singleton6.class){
                if (instance == null ){
                    return new Singleton6();
                }
            }
        }
        return instance;
    }
}
