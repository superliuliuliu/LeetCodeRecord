package com.concurrentlearn.threadlocallearn;

import java.text.SimpleDateFormat;

public class ThreadLocalDateFormat {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");

    static class SafeDateFormat{
        static final ThreadLocal<SimpleDateFormat> ts = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd\tHH:mm:ss"));
        static SimpleDateFormat get(){
            return ts.get();
        }
    }

    // 测试非线程安全的情况
    public static void main(String[] args) {
        ThreadLocalDateFormat t1;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });

        // 启动两个线程
        thread.start();
        thread1.start();

    }
}
