package com.threadcoreknowledge.startThread;

/**
 *
 * @description 启动线程的正确方法
 * @author liugaoyang
 * @date 2019/10/4 14:13
 * @version 1.0.0
 */
public class findStartMethod {
    public static void main(String[] args) {
        // 使用run方法尝试启动线程
        Runnable runnable = ()->{
          System.out.println(Thread.currentThread().getName());
        };
        runnable.run();
        // 使用 start()方法启动线程
        new Thread(runnable).start();
    }
}
