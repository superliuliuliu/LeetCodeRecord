package com.threadcoreknowledge.stopThread;

// 错误的停止线程的方法 使用stop停止线程
public class wrongWayStopThreadUseStop implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println("第" + i + "组数据");
            for (int j = 0; j < 10; j++){
                System.out.println("第" + j + "个人");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new wrongWayStopThreadUseStop());
        t1.start();
        Thread.sleep(1000);
        t1.stop();
    }
}
