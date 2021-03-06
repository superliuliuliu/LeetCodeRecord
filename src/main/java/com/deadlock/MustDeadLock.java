package com.deadlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 必然发生死锁的情况
 * @date 2019/11/12 23:01
 */
public class MustDeadLock {

    private static Object lock1 = new Object();

    private static Object lock2 = new Object();


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("两个线程开始同时抢占锁资源"));
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + "获取资源lock1");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + "获取资源lock2");
                }
            }
        }).start();

        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + "获取资源lock2");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + "获取资源lock1");
                }
            }
        }).start();

        System.out.println("主程序执行完毕");

    }
}
