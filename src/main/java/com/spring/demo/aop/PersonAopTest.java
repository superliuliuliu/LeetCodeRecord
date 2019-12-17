package com.spring.demo.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description Aop的测试代码类
 * @date 2019/12/17 15:44
 */
public class PersonAopTest {

    public static void main(String[] args) {
        // 创建IOC容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        // 从容器中获取bean实例
        Person p = ctx.getBean(Person.class);
        p.drive();
    }
}
