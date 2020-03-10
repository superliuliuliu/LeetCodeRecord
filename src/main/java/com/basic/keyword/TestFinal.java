package com.basic.keyword;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2020/2/23 10:42
 */
public class TestFinal {

    private final Integer a;

    public TestFinal(Integer a) {
        this.a = a;
    }

    public static void main(String[] args) {
        TestFinal testFinal = new TestFinal(10);
    }
}
