package com.concurrentlearn.prodconmodel;

public class Print100 {
    private static Integer num = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread odd = new Thread(new Runnable() {
            // 奇数
            @Override
            public void run() {
                while (num <= 100) {
                    synchronized (lock) {
                        // 位运算可以提高效率
                        if ((num & 1) != 0) {
                            if (num<=100){
                                System.out.println("打印奇数：" + num);
                            }
                            num++;
                        }
                    }
                }
            }
        });
        Thread even = new Thread(new Runnable() {
            //偶数
            @Override
            public void run() {
                while (num <= 100) {
                    synchronized (lock) {
                        // 位运算可以提高效率
                        if ((num & 1) == 0) {
                            if (num <= 100){
                                System.out.println("打印偶数：" + num);
                            }
                            num++;
                        }
                    }
                }
            }
        });
        even.start();
        odd.start();
    }
}