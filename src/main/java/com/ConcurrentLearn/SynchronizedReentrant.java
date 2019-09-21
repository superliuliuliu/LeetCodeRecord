package com.ConcurrentLearn;

import lombok.extern.slf4j.Slf4j;

// Synchronized 可重入性验证
public class SynchronizedReentrant {
    int a = 0;

    private synchronized void method(){
        System.out.println("方法一执行：a=" + a);
        if (a == 0){
            a++;
            method();
        }
    }

    public static void main(String[] args) {
        SynchronizedReentrant instance = new SynchronizedReentrant();
        instance.method();

    }
}
