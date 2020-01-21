package com.liugaoyang.xin.spring.bean.definition;

import com.liugaoyang.xin.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 基于注解的方式注册bean
 * @date 2020/1/19 21:17
 */
public class AnnotationBeanDefinitionDemo2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.refresh();
        annotationConfigApplicationContext.register(Config.class);
        Map<String, Config> result = annotationConfigApplicationContext.getBeansOfType(Config.class);
        System.out.println(result);
        // 关闭上下文
        annotationConfigApplicationContext.close();
    }

    // 使用@Component注解
    @Component
    public static class Config{

        @Bean(name = {"user", "alias"})
        public User user(){
            User user = new User();
            user.setId(1);
            user.setName("lgy");
            return user;
        }
    }
}
