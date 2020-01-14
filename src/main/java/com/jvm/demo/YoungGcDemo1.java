package com.jvm.demo;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 模拟YoungGC的场景
 * @date 2020/1/13 13:20
 */
public class YoungGcDemo1 {
    public static void main(String[] args) {
        // 声明1M的数组
        byte[] array1 = new byte[1024*1024];
        array1 = new byte[1024*1024];
        array1 = new byte[1024*1024];
        array1 = null;

        // 2M的数组
        byte[] array2 = new byte[2*1024*1024];

    }
}
