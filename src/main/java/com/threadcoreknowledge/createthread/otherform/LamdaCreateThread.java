package com.threadcoreknowledge.createthread.otherform;

public class LamdaCreateThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
