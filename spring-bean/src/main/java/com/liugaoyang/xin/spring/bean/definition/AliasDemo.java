package com.liugaoyang.xin.spring.bean.definition;

import com.liugaoyang.xin.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 为bean定制别名
 * @date 2020/1/18 19:56
 */
public class AliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definition-context.xml");
        User user = beanFactory.getBean("lgyUser", User.class);
        User u = beanFactory.getBean("user", User.class);
        System.out.println(user == u);
    }
}
