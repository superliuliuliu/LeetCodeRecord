package com.ConcurrentLearn;

// Synchronized 对象锁之方法修饰符形式
public class SynchronizedObjectLockMethod implements Runnable{

    private static SynchronizedObjectLockMethod instance = new SynchronizedObjectLockMethod();

    @Override
    public void run() {
        method();
    }

    private synchronized void method(){
        System.out.println("Synchronized对象锁的方法修饰符形式，线程的名称为："+ Thread.currentThread().getName());

        // 当前线程睡眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程：" + Thread.currentThread().getName() + "释放对象锁！");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        while(t1.isAlive()||t2.isAlive()){

        }
        System.out.print("线程执行完毕");
    }
}
