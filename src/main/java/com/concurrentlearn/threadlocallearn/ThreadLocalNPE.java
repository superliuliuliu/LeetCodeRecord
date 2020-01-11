package com.concurrentlearn.threadlocallearn;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 自动拆装箱产生的空指针异常
 * @date 2020/1/11 15:47
 */
public class ThreadLocalNPE {
    private ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();

    public void set(){
        longThreadLocal.set(Thread.currentThread().getId());
    }

    public long get(){
        return longThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalNPE threadLocalNPE = new ThreadLocalNPE();
        threadLocalNPE.get();
    }
}
