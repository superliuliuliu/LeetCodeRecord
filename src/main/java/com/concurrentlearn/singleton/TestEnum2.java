package com.concurrentlearn.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 枚举类的反射测试
 * @date 2019/12/7 11:13
 */
public class TestEnum2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumInstance instance = EnumInstance.getInstance();
        instance.setData(new Object());
        Class objectClass = EnumInstance.class;
        Constructor constructor = objectClass.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        EnumInstance newInstance = (EnumInstance) constructor.newInstance("lgy", 666);
        System.out.println(instance.getData());
        System.out.println(newInstance.getData());
        System.out.println(instance.getData() == newInstance.getData());
    }
}
