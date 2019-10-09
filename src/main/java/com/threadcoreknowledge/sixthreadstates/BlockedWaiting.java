package com.threadcoreknowledge.sixthreadstates;

/**
 *
 * @description 线程的剩余三种状态
 * @author liugaoyang
 * @date 2019/10/9 14:27
 * @version 1.0.0
 */
public class BlockedWaiting implements Runnable{

    // static表示静态变量与对象无关 final表示该类的地址不变
    private static final Object lock = new Object();

    @Override
    public void run() {
        synchronized (BlockedWaiting.class){
//            for (int i = 0; i < 1000; i++){
//                System.out.println(Thread.currentThread().getName() +"正在执行" + i);
//            }
            try {
                // 线程睡眠处于TimeWaiting状态
                Thread.currentThread().sleep(1000);
                // 线程处于wait状态
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new BlockedWaiting(),"t1");
        Thread t2 = new Thread(new BlockedWaiting(),"t2");

        t1.start();
        t2.start();

        System.out.println("线程t1的状态："+ t1.getState());
        System.out.println("线程t2的状态："+ t2.getState());

        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程t1的状态："+ t1.getState());
    }
}
