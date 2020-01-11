package com.concurrentlearn.AQSexample;

import java.util.concurrent.*;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description AQS类CyclicBarrier的使用测试
 * @date 2019/10/14 19:05
 */
public class CylicBarrierExample1 {

    // 计数器5 当五个线程都执行到相关逻辑之时 所有的线程才开始同步执行其后的操作
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private static final int threadCount = 10;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(5);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 500, TimeUnit.MILLISECONDS, workQueue);
        for (int i = 0; i < threadCount; i++){
            int num = i;
            Thread.sleep(1000);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    doTask(num);
                }
            });
        }
        // 关闭线程池
        executor.shutdown();

    }
    private static void doTask(int threadNum){
        try {
            // 线程之前相关的业务逻辑
            Thread.sleep(1000);
            System.out.println(threadNum + "：线程等待中");
            // 线程等待
            cyclicBarrier.await();
            System.out.println(threadNum + "：线程继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
