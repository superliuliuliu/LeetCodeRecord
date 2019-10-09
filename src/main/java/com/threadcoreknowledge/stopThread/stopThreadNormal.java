package com.threadcoreknowledge.stopThread;

/**
 *
 * @description 停止线程的最常见情况
 * @author liugaoyang
 * @date 2019/10/6 10:09
 * @version 1.0.0
 */
public class stopThreadNormal implements Runnable{

    // 测试打印出10000的倍数（不超过最大值）
    @Override
    public void run() {
        int i = 10000;
        // 判断线程的状态 若线程已中断 线程不再运行
        while(i < Integer.MAX_VALUE && !Thread.currentThread().isInterrupted()){
            if (i % 10000 == 0){
                System.out.println(i);
            }
            i++;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new stopThreadNormal());
        t.start();
        // 正常情况下 打印需要5-6秒 我们让其运行一秒后线程中断 看线程的执行情况
        Thread.sleep(1000);
        // 通知线程中断
        t.interrupt();

    }
}
