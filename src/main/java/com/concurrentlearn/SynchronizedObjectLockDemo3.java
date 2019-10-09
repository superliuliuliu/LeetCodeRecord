package com.concurrentlearn;

// 测试多个线程同时访问 同步方法与非同步方法
public class SynchronizedObjectLockDemo3 implements Runnable{
    static SynchronizedObjectLockDemo3 instance = new SynchronizedObjectLockDemo3();

    @Override
    public void run() {
        if (Thread.currentThread().getName()=="Thread-0"){
            method1();
        }else{
            method2();
        }
    }

    private synchronized void method1(){
        System.out.println("同步方法在执行，线程的名称为："+ Thread.currentThread().getName());
        // 线程睡眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("同步方法执行完毕："+ Thread.currentThread().getName());
    }

    private void method2(){
        System.out.println("非同步方法在执行，线程的名称为："+ Thread.currentThread().getName());
        // 线程睡眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("非同步方法执行完毕："+ Thread.currentThread().getName());

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        // 同时启动两个线程 一个线程去执行同步方法 一个线程去执行非同步方法 看方法执行是否会阻塞
        t1.start();
        t2.start();

        while (t1.isAlive()||t2.isAlive()){

        }
        System.out.print("线程执行完毕");
    }
}
