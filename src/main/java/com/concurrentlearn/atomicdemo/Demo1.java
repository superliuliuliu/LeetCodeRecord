package com.concurrentlearn.atomicdemo;

import java.util.concurrent.*;

// 线程计数同步类
public class Demo1 {
    // 模拟200个线程同时执行
    private static int threadCount = 200;
    // 总共计数5000次
    private static int countTotal = 5000;
    // 计数的值
    private static int  count = 0;

    public static void main(String[] args) throws InterruptedException {
        // 使用内存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 使用信号量控制最多允许200个线程同时执行
        Semaphore semaphore = new Semaphore(threadCount);
        // 线程倒计时器 当线程总数到达指定值时开始 所有线程执行
        CountDownLatch countDownLatch = new CountDownLatch(countTotal);
        for (int i = 0; i < countTotal; i++){
            // 新建线程
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        add();
                        semaphore.release();
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        countDownLatch.await();
        // 释放线程池
        executorService.shutdown();
        System.out.println("count:" + count);
    }

    public static void add(){
        count++;
    }
}
