package com.concurrentlearn.AQSExample;

import java.util.concurrent.*;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description Semaphore使用例子1
 * @date 2019/10/14 15:55
 */
public class SemaphoreExample1 {
    private static final int threadCount = 10;

    public static void main(String[] args) {
        // 允许三个线程并发执行
        Semaphore semaphore = new Semaphore(3);
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 1, TimeUnit.SECONDS, workQueue);
        for (int i = 0; i < threadCount; i++) {
            final int num = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取许可
                        semaphore.acquire();
                        System.out.println("第" + num + 1 + "个线程");
                        // 释放许可
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {

        } finally {
            // 关闭线程池
            threadPoolExecutor.shutdown();
        }
        System.out.println("等待前10个线程执行完成");
    }
}
