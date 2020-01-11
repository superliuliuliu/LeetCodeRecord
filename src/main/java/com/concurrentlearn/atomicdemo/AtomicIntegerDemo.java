package com.concurrentlearn.atomicdemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 测试Atimc*基础原子类的安全性
 * @date 2020/1/11 16:42
 */
public class AtomicIntegerDemo implements Runnable{

    private static final AtomicInteger a = new AtomicInteger(0);
    private static volatile int b = 0;

    public void incrementAtomicInteger(){
        a.getAndIncrement();
    }

    public void incrementNormalInt(){
        b++;
    }


    @Override
    public void run() {
        for (int i = 0; i<2000;i++){
            incrementAtomicInteger();
            incrementNormalInt();
        }
    }

    public static void main(String[] args) {
        AtomicIntegerDemo atomicIntegerDemo = new AtomicIntegerDemo();
        Thread t1 = new Thread(atomicIntegerDemo);
        Thread t2 = new Thread(atomicIntegerDemo);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println(b);
    }

}
