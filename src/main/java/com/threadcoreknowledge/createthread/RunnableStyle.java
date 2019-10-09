package com.threadcoreknowledge.createthread;

/**
 *
 * @description 使用实现Runnable接口的方式来新建一个线程
 * @author liugaoyang
 * @date 2019/10/3 15:52
 * @version 1.0.0
 */
public class RunnableStyle implements Runnable{
    @Override
    public void run() {
        System.out.println("创建一个新的线程"+ Thread.currentThread().getId());
    }


    public static void main(String[] args) {
        RunnableStyle instance = new RunnableStyle();
        System.out.println(Thread.currentThread().getId());
        Thread t1 = new Thread(instance);
        t1.start();

    }
}