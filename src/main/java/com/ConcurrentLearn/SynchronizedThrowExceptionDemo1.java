package com.ConcurrentLearn;

// 验证 线程执行出错 Synchronized方法是否会释放锁资源
public class SynchronizedThrowExceptionDemo1 implements Runnable{

    static SynchronizedThrowExceptionDemo1 instance = new SynchronizedThrowExceptionDemo1();

    @Override
    public void run() {
        method();
    }

    private synchronized void method(){
        System.out.println("同步方法(对象锁)在执行，线程的名称为："+ Thread.currentThread().getName());
        // 线程睡眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 模拟线程运行出错的情况
        int x = 100/0;
        System.out.println("同步方法执行完毕："+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        while (t1.isAlive()||t2.isAlive()){

        }
        System.out.print("线程执行完毕");

    }
}
