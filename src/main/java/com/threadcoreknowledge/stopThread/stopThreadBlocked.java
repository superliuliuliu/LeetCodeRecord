package com.threadcoreknowledge.stopThread;

/**
 *
 * @description  在线程阻塞的时候中断线程
 * @author liugaoyang
 * @date 2019/10/6 11:31
 * @version 1.0.0
 */
public class stopThreadBlocked  implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new stopThreadBlocked());
        t.start();
        Thread.sleep(1000);
        // 发送线程中断信号
        t.interrupt();
    }

    @Override
    public void run() {
        int num = 0;
        while(num <= 300){
            if (num % 100 == 0){
                System.out.println(num);
            }
            num++;
        }
        // 线程在执行完成一阶段的任务后 等待一段时间  在这个等待时间内发生了中断
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
