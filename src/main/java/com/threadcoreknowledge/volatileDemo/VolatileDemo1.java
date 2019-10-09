package com.threadcoreknowledge.volatileDemo;

public class VolatileDemo1 implements Runnable {

    // volatile关键字修饰的标志位
    private volatile boolean flag = false;

    @Override
    public void run() {
        int num = 0;
        while(num<Integer.MAX_VALUE && !flag){
            if (num % 1000 == 0){
                System.out.println(num);
                try {
                    //睡眠1ms
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num++;
            
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo1 demo1 = new VolatileDemo1();
        Thread t1 = new Thread(demo1);
        t1.start();
        Thread.sleep(5000);
        // 修改标志位以达到停止线程的目的
        demo1.flag = true;
    }
}
