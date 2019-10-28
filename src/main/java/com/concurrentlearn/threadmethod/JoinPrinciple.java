package com.concurrentlearn.threadmethod;

// join方法的原理本质是利用了Object类的wait方法
public class JoinPrinciple {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 当前线程睡眠1s
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行完成");
            }
        });
        // 启动t1线程
        t1.start();
        synchronized (t1){
            try {
                t1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("主线程执行完成");
    }
}
