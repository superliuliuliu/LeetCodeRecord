package com.spring.demo.ioc.circular;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 循环依赖演示
 * @date 2020/2/1 14:50
 */
public class CircularDependencyDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.spring.demo.ioc.component");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
