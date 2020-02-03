package com.spring.demo.ioc.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 循环依赖测试类
 * @date 2020/2/1 14:48
 */
@Component
public class Cat {
    @Autowired
    Person person;
}
