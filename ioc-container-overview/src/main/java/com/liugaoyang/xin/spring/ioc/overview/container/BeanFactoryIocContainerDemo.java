package com.liugaoyang.xin.spring.ioc.overview.container;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description IOC Container 测试
 * @date 2020/1/15 11:29
 */
public class BeanFactoryIocContainerDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // Bean读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-injection-context.xml";
        int count = reader.loadBeanDefinitions(location);
        System.out.println("加载bean的数量为：" + count);
    }



}
