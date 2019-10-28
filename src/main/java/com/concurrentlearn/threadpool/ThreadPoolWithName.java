package com.concurrentlearn.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @description 将线程池中的线程名称设置为有意义的名称，方便日志中查看记录
 * @author liugaoyang
 * @date 2019/10/10 16:05
 * @version 1.0.0
 */
class MyThreadFactory implements ThreadFactory{
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    MyThreadFactory() {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        namePrefix = "SpecialName-" +
                poolNumber.getAndIncrement() +
                "-thread-";
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}

public class ThreadPoolWithName {
    // 创建一个线程池
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                20,
                10,
                TimeUnit.SECONDS,
                workQueue,
                new MyThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        Runnable task1 = ()->{
            System.out.println("线程名称为："+Thread.currentThread().getName());
        };
        Runnable task2 = ()->{
            System.out.println("线程名称为："+Thread.currentThread().getName());
        };
        threadPoolExecutor.execute(task1);
        threadPoolExecutor.execute(task2);
        threadPoolExecutor.shutdown();

    }

}
