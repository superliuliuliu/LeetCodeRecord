package com.concurrentlearn.AQSexample;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 我的基于AQS类实现的同步辅助类
 * @date 2020/2/3 20:49
 */
public class MyAQSToolDemo {

    public static void main(String[] args) throws InterruptedException {
        MyAQSToolDemo myAQSToolDemo = new MyAQSToolDemo();
        for (int i = 0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程等待闸门打开：" + Thread.currentThread().getName());
                    myAQSToolDemo.await();
                    System.out.println("闸门开启：" + Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(5000);
        // 开闸
        myAQSToolDemo.signal();
    }

    private final Sync sync = new Sync();

    /**
     * signal
     * @description 启动通知 代表锁已经释放线程可以运行了
     * @author liugaoyang
     * @date 2020/2/3 21:54
     * @version 1.0.0
     */
    public void signal(){
        sync.releaseShared(0);
    }

    /**  
     * await
     * @description 等待执行 需要判断一个条件  即等待锁对象释放 state变量为0时代表 其他线程可以执行 否则一直等待
     * @author liugaoyang
     * @date 2020/2/3 21:49
     * @version 1.0.0
     */
    public void await(){
        sync.acquireShared(0);
    }

    private  class Sync extends AbstractQueuedSynchronizer{

        /**
         * tryAcquireShared
         * @description 获取锁相关逻辑  获取成功返回正数  获取失败返回负数（线程加入到等待队列继续等待）
         * 返回值代表这个门栓是否打开允许其他线程执行  正数代表允许执行
         * @author liugaoyang
         * @date 2020/2/3 21:53
         * @version 1.0.0
         */
        @Override
        protected int tryAcquireShared(int arg) {
            // state默认为0  获取内存之中的state变量 state为1代表允许线程进入执行 否则不允许
            return (getState() == 1) ? 1: -1;
        }

        /**
         * tryReleaseShared
         * @description 释放锁 即基于cas修改state变量
         * 即打开门栓操作 即修改state值
         * 返回值为true代表打开成功 应该唤醒阻塞在门栓处的执行逻辑
         * @author liugaoyang
         * @date 2020/2/3 21:53
         * @version 1.0.0
         */
        @Override
        protected boolean tryReleaseShared(int arg) {
            // state变量1操作
            setState(1);
            return true;
        }
    }

}
