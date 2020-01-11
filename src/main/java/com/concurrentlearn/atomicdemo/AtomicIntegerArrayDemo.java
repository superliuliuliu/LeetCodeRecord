package com.concurrentlearn.atomicdemo;

import com.concurrentlearn.threadlocallearn.ThreadLocalNPE;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description AtomicInterArray测试类 数组类型的原子类测试使用
 * @date 2020/1/11 22:25
 */
public class AtomicIntegerArrayDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(100);
        ArrayIncrement arrayIncrement = new ArrayIncrement(atomicIntegerArray);
        Thread t1 = new Thread(arrayIncrement);
        Thread t2 = new Thread(arrayIncrement);
        t1.start();
        t2.start();

        Thread.sleep(10000);
        System.out.println(atomicIntegerArray.get(1));
    }
}

class ArrayIncrement implements Runnable{

    private AtomicIntegerArray array;

    public ArrayIncrement(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++){
            // 对位于i位置的AtomicInteger做增加操作
            array.getAndIncrement(i);
        }
    }
}
