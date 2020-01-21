package com.liugaoyang.xin.spring.bean.definition;

import com.liugaoyang.xin.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description BeanDefinition构建实例
 * @date 2020/1/18 17:15
 */
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        // 通过BeanDefinitionBuilder 来构建实例
        BeanDefinitionBuilder b = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 设置bean的属性
        b.addPropertyValue("id", 12).addPropertyValue("name", "刘");
        BeanDefinition beanDefinition = b.getBeanDefinition();
        System.out.println(beanDefinition);
        // 通过AbstractBeanDefinition 获取BeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        // 设置bean的属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("id", 12);
        mutablePropertyValues.addPropertyValue("name", "高阳");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
        System.out.println(genericBeanDefinition);

    }

}
