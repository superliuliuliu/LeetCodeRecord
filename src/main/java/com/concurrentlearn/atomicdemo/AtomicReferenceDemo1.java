package com.concurrentlearn.atomicdemo;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo1 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 1);
        count.compareAndSet(1, 3);
        count.compareAndSet(2, 4);
        count.compareAndSet(3, 100);
        count.compareAndSet(4, 200);
        System.out.println(count.get());

    }
}
