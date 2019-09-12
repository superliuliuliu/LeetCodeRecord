package com.ConcurrentLearn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 模拟Synchronized获取锁和释放锁的时机
public class SynchronizedHookGetandDrop {

    private Lock lock = new ReentrantLock();

    public synchronized void method1(){
        System.out.print("Synchronized形式的锁！");
    }

    public void method2(){
        // 模拟获取锁
        lock.lock();
        try{
            System.out.print("Lock形式的锁！");
        }finally {
            // 模拟释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedHookGetandDrop instance = new SynchronizedHookGetandDrop();
        instance.method1();
        instance.method2();
    }
}
