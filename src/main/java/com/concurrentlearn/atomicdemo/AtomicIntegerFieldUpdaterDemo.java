package com.concurrentlearn.atomicdemo;


import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterDemo> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterDemo.class, "count");

    private volatile int count = 100;

    public static void main(String[] args) {

    }
}
