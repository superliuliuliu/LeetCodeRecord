package com.deadlock;

import java.util.Arrays;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2019/11/17 11:42
 */
public class StringTest {
//    public static void main(String[] args) {
//        // 新建“lgy”对象 对象存储在堆之中
//        String str = new String("lgy");
//        // 对象入池
//        String str2 = "lgy";
//        // 将str入池 返回池中的引用
//        String str1 = str.intern();
//        System.out.println(str == str1);
//        System.out.println(str1 == str2);
//
//    }
public static void main(String[] args) {
    String s1 = new StringBuilder("").append("lgy").toString();
    System.out.println(s1 == s1.intern());
}
}
