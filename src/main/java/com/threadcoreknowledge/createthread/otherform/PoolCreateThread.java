package com.threadcoreknowledge.createthread.otherform;

import com.sun.jmx.snmp.tasks.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolCreateThread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i< 100; i++){
            executorService.submit(new Task() {
                @Override
                public void cancel() {

                }

                @Override
                public void run() {
                    System.out.println("线程池的方式创建线程：" + Thread.currentThread().getName());
                }
            });
        }
    }
}
