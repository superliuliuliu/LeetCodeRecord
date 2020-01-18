package com.liugaoyang.xin.spring.ioc.overview.dependency.lookup;

import com.liugaoyang.xin.spring.ioc.overview.annotation.Super;
import com.liugaoyang.xin.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


/**
 * @author liugaoyang
 * @version 1.0.0
 * @description IOC实现方式之依赖查找 之实时查找
 * @date 2020/1/14 9:34
 */
public class DependencyLookUpDemo {

    public static void main(String[] args) {
        // 启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        //lookUpInRealTime(beanFactory);
        //lookUpInDelayTime(beanFactory);
        lookUpByType(beanFactory);
        lookUpCollectionByType(beanFactory);
        lookUpByAnnotation(beanFactory);
    }

    private static void lookUpByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注@Super的所有User对象" + users);
        }
    }

    private static void lookUpCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("类型查找中的集合" + users);
        }
    }

    private static void lookUpByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("类型查找" + user);
    }

    /**
     * lookUpInRealTime
     * @description 实时查找
     * @author liugaoyang
     * @date 2020/1/14 10:23
     * @version 1.0.0
     */
    private static void lookUpInRealTime(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }

    /**
     * lookUpInDelayTime
     * @description 延迟查找
     * @param beanFactory spring上下文
     * @author liugaoyang
     * @date 2020/1/14 10:24
     * @version 1.0.0
     */
    private static void lookUpInDelayTime(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找" + user);
    }

}
