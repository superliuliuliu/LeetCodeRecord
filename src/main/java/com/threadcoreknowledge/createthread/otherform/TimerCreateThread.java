package com.threadcoreknowledge.createthread.otherform;

import java.util.Timer;
import java.util.TimerTask;

public class TimerCreateThread {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器创建线程"+ Thread.currentThread().getName());
            }
            // delay代表初始的延时时间 period代表运行周期
        }, 1000, 1000);
    }
}
