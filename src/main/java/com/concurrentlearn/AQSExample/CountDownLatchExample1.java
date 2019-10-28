package com.concurrentlearn.AQSExample;

import java.io.File;
import java.util.concurrent.*;

/**
 * 
 * @description CountDownLatch演示类
 * @author liugaoyang
 * @date 2019/10/14 14:39
 * @version 1.0.0
 */
public class CountDownLatchExample1 {

    // 计数器
    private static final int threadCount = 10;

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 1, TimeUnit.SECONDS, workQueue);
        for (int i = 0; i < threadCount; i++){
            final int num = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        System.out.println("第"+num+1+"个线程");
                    }finally {
                        // 线程执行完毕计数器减1
                        countDownLatch.countDown();
                        System.out.println("第"+num+1+"个线程执行完成");
                    }
                }
            });
        }
        File file = new File(System.getProperty("user.dir") +
                System.getProperty("file.separator") + "pom.xml");
        System.out.println(file.getName());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 关闭线程池
            threadPoolExecutor.shutdown();
        }
        System.out.println("等待前10个线程执行完成再执行");

    }

}
