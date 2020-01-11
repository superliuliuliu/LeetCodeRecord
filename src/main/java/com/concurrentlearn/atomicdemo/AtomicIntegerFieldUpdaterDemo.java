package com.concurrentlearn.atomicdemo;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo implements Runnable{

    static Test t1;
    static Test t2;

    private static AtomicIntegerFieldUpdater<Test> updater = AtomicIntegerFieldUpdater.newUpdater(Test.class, "score");

    @Override
    public void run() {
        for (int i = 0; i < 1000;i++){
            t1.score++;
            updater.getAndIncrement(t2);
        }
    }

    // 待升级的类
    public static class Test{
        volatile int score;
    }

    public static void main(String[] args) throws InterruptedException {
        t1 = new Test();
        t2 = new Test();
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(t1.score);
        System.out.println(t2.score);

    }
}
