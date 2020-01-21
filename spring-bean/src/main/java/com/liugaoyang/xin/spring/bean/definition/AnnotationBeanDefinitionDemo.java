package com.liugaoyang.xin.spring.bean.definition;

import com.liugaoyang.xin.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 基于注解的方式注册bean
 * @date 2020/1/19 21:17
 */
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.refresh();
        // 注册配置类
        annotationConfigApplicationContext.register(Config.class);
        System.out.println(annotationConfigApplicationContext.getBeansOfType(Config.class));
        // 关闭上下文
        annotationConfigApplicationContext.close();
    }


    public static class Config{

        // 1.通过@Bean的方式注册
        @Bean(name = {"user", "alias"})
        public User user(){
            User user = new User();
            user.setId(1);
            user.setName("lgy");
            return user;
        }
    }
}
