package com.threadcoreknowledge.createthread;

/**
 *
 * @description 新建线程的两种方法综合
 * @author liugaoyang
 * @date 2019/10/4 11:36
 * @version 1.0.0
 */
public class BothMethodToThread{
    public static void main(String[] args) {
        // 匿名内置类
        Thread t1 = new Thread(new Runnable() {
            // 实现Runnable接口的run方法
            @Override
            public void run() {
                System.out.println("这是实现Runnable接口的实现方法" + Thread.currentThread().getName());
            }
        }){
            // 重写Thread类的run方法
            @Override
            public void run() {
                System.out.println("这是继承Thread类的实现方法" + Thread.currentThread().getName());
            }
        };
        t1.start();
    }
}
