package com.concurrentlearn.AQSexample;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 利用信号量实现的对象限流器
 * 同一时刻至多允许N个线程获取对象
 * R代表返回值
 * @date 2019/10/26 11:16
 */
public class LimiterBySemaphore<T, R> {

    // 存储对象使用
    final private List<T> pool;

    // 信号量
    final private Semaphore semaphore;

    // 构造函数
    public LimiterBySemaphore(int size, T t){
        // 使用线程安全的容器来存储对象
        pool = new Vector<T>(){};

        semaphore = new Semaphore(size);
        // 向容器之中添加size个相同的对象
        for (int i = 0; i < size; i++){
            pool.add(t);
        }
    }

    R exec(Function<T, R> function) throws InterruptedException {
        T t = null;
        // 线程获取一个信号量 计数器-1
        semaphore.acquire();
        // 获取一个对象池中对象
        try{
            t = pool.remove(0);
            return function.apply(t);
        }finally {
            // 使用完成之后将对象返回池中
            pool.add(t);
            // 释放信号量 计数器+1
            semaphore.release();
        }
    }

    /**
     * main
     * @description 测试限流器
     * @author liugaoyang
     * @date 2019/10/26 11:28
     * @version 1.0.0
     */
    public static void main(String[] args) {
        // 对象池中存储的是long类型数据 返回的是string
        // 对象池初始化了10 个100L数字
        LimiterBySemaphore<String, String> limiter = new LimiterBySemaphore(10, "100");
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 1, TimeUnit.SECONDS, workQueue);
        for (int i = 0; i < 20; i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        limiter.exec(t->{
                            System.out.println("当前线程id:"+Thread.currentThread().getId()+",当前获取到的对象："+t);
                            return t;
                        });
                        // 线程睡眠1000ms
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // 关闭线程池
        threadPoolExecutor.shutdown();
    }
}
