package com.threadcoreknowledge.createthread;

/**
 *
 * @description 继承Thread类的形式来新建一个线程
 * @author liugaoyang
 * @date 2019/10/3 15:55
 * @version 1.0.0
 */
public class ExtendThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("创建一个新的线程"+ Thread.currentThread().getId());
    }
    public static void main(String[] args) {
        ExtendThreadStyle instacne = new ExtendThreadStyle();
        instacne.start();
    }
}
