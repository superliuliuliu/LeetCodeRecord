package com.concurrentlearn;

// Synchornized 对象锁之同步代码块形式学习下
public class SynchronizedObjectLockCodeBlocks implements Runnable {

    private static SynchronizedObjectLockCodeBlocks Instance = new SynchronizedObjectLockCodeBlocks();
    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        // 版本2 使用Synchronized 对指定对象加锁

        synchronized (lock1){
            System.out.println("获取lock1，线程的名称为："+ Thread.currentThread().getName());
            // 线程睡眠3秒
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("释放lock1："+ Thread.currentThread().getName());
        }

        synchronized (lock2){
            System.out.println("获取lock2，线程的名称为："+ Thread.currentThread().getName());
            // 线程睡眠3秒
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("释放lock2："+ Thread.currentThread().getName());
        }

        // 使用Synchronized 关键字来对指定对象加锁 这里是对当前对象加锁 保证多个线程的线程安全
        // 版本1 使用Synchronized 对当前对象加锁
//        synchronized (this){
//            System.out.println("Sysnchronized对象锁代码块形式，线程的名称为："+ Thread.currentThread().getName());
//            // 线程睡眠3秒
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("线程执行完成，线程的名称为："+ Thread.currentThread().getName());
//        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(Instance);
        Thread t2 = new Thread(Instance);
        t1.start();
        t2.start();

        // 线程未执行终结之前 无限循环
        while (t1.isAlive() || t2.isAlive()){
        }
        System.out.println("线程执行完成！");
    }

}
