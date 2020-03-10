package com.basic.pool;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2020/2/23 22:34
 */
public class IntegerLongDemo {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = -129;
        Integer d = -129;

        Long e = 127l;
        Long f = 127l;
        Long g = -129l;
        Long h = -129l;

        // true
        System.out.println(a == b);
        // false
        System.out.println(c == d);

        // true
        System.out.println(e == f);
        // false
        System.out.println(g == h);

    }
}
