package com.spring.demo.aop;

import org.springframework.stereotype.Component;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description aop的测试类
 * @date 2019/12/17 15:37
 */
@Component(value = "person")
public class Person {

    public void drive(){
        System.out.println("开车");
    }
}
