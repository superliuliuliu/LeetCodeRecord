package com.threadcoreknowledge.startThread;

/**
 *
 * @description 测试启动线程两次
 * @author liugaoyang
 * @date 2019/10/4 14:19
 * @version 1.0.0
 */
public class startTwice {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();
        t1.start();
    }
}
