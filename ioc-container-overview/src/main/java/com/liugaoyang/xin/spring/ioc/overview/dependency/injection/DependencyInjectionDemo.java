package com.liugaoyang.xin.spring.ioc.overview.dependency.injection;

import com.liugaoyang.xin.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description spring ioc的依赖注入实现
 * @date 2020/1/14 11:29
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        System.out.println("Users:" + userRepository.getUsers());

    }
}
