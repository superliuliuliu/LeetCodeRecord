package com.concurrentlearn.prodconmodel;

import java.util.Stack;

// 使用 wait/notify机制来实现打印0-100的目标
public class Print100WithSignal {

    private static int num = 0;
    private static final Object lock = new Object();

    static class print implements Runnable{
        @Override
        public void run() {
            while (num <= 100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+"打印：" + num);
                    // num+1
                    num++;
                    // 唤醒另外一个线程
                    lock.notify();
                    if (num <= 100){
                        try {
                            // 线程睡眠 释放锁资源
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new print(), "奇数");
        Thread t2 = new Thread(new print(), "偶数");
        t2.start();
        t1.start();

    }
}


