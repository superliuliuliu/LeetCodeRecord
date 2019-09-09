package com.ConcurrentLearn;

// Synchronized关键字 实现类锁中的静态方法锁
public class SynchronizedClassLockdemo1  implements Runnable{

    // 这里新建两个实例
    private static SynchronizedClassLockdemo1 instance1 = new SynchronizedClassLockdemo1();
    private static SynchronizedClassLockdemo1 instance2 = new SynchronizedClassLockdemo1();


    // Synchronized关键字 类锁中的静态方法锁
    private  static synchronized void method1(){
        System.out.println("Synchronized类锁的静态方法锁形式，线程的名称为："+ Thread.currentThread().getName());
        // 当前线程睡眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + "释放类锁！");
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
