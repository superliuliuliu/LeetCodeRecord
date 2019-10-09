package com.concurrentlearn.threadlocallearn;

import java.text.SimpleDateFormat;

public class ThreadLocalDateFormat {

    static class SafeDateFormat{
        static final ThreadLocal<SimpleDateFormat> ts = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd\tHH:mm:ss"));
        static SimpleDateFormat get(){
            return ts.get();
        }
    }

    public static void main(String[] args) {

    }
}
