package com.spring.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2019/12/17 15:39
 */
@Component
@Aspect
public class CarAop {

    @Before("execution(* com.spring.demo.aop.Person.drive())")
    public void before(){
        System.out.println("巡视车体周围情况");
        System.out.println("系安全带");
        System.out.println("发动");
    }

    @After("execution(* com.spring.demo.aop.Person.drive())")
    public void after(){
        System.out.println("熄火");
        System.out.println("锁车");
    }



}
