package com.threadcoreknowledge.sixthreadstates;

/**
 *
 * @description 线程的new runnable terminated状态展示
 * @author liugaoyang
 * @date 2019/10/9 14:15
 * @version 1.0.0
 */
public class NewRunnableTerminate implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i<10000; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new NewRunnableTerminate());
        System.out.println("新建线程后的状态"+t1.getState());
        t1.start();
        System.out.println("线程执行start的状态"+t1.getState());
        // 主线程睡眠10ms保证t1处于执行的状态
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程执行中的状态"+t1.getState());
        // 当前线程睡眠1s保证线程处于运行完后的状态
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程执行完的状态"+t1.getState());
    }
}
