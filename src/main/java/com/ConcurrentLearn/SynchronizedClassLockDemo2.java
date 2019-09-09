package com.ConcurrentLearn;

// Synchronized 类锁之使用代码块实现类锁
public class SynchronizedClassLockDemo2 implements Runnable{
    // 这里新建两个实例
    private static SynchronizedClassLockDemo2 instance1 = new SynchronizedClassLockDemo2();
    private static SynchronizedClassLockDemo2 instance2 = new SynchronizedClassLockDemo2();

    private  static void method1(){
        synchronized (SynchronizedClassLockDemo2.class){
            System.out.println("Synchronized类锁的方法块形式，线程的名称为："+ Thread.currentThread().getName());
            // 当前线程睡眠3秒
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程：" + Thread.currentThread().getName() + "释放类锁！");
        }
    }

    @Override
    public void run() {
        method1();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);

        t1.start();
        t2.start();
        while(t1.isAlive()||t2.isAlive()){

        }
        System.out.print("线程执行完毕");
    }
}
