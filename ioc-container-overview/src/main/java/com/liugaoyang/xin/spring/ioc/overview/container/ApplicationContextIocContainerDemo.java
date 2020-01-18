package com.liugaoyang.xin.spring.ioc.overview.container;

import com.liugaoyang.xin.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2020/1/15 11:43
 */
public class ApplicationContextIocContainerDemo {

    public static void main(String[] args) {
        // 创建ApplicationContext 以注解的形式注入
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ApplicationContextIocContainerDemo.class);
        // 启动应用上下文
        annotationConfigApplicationContext.refresh();
        User user = annotationConfigApplicationContext.getBean(User.class);
        System.out.println("类型查找" + user);

    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(1);
        user.setName("lgy");
        return user;
    }
}
