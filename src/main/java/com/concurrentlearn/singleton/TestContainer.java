package com.concurrentlearn.singleton;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 测试容器单例
 * @date 2019/12/7 13:22
 */
public class TestContainer {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();
        System.out.println("main program and");

    }
}

class Task implements Runnable{

    @Override
    public void run() {
        ContainerSingleton.putInstance("object", new Object());
        Object o = ContainerSingleton.getInstance("object");
        System.out.println(Thread.currentThread().getName() + o);
    }
}
