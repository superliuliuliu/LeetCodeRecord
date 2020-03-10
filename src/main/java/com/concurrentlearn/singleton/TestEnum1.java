package com.concurrentlearn.singleton;

import java.io.*;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 枚举类单例模式的测试类
 * @date 2019/12/7 10:27
 */
public class TestEnum1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /**
         * 前面一部分可以证明 单例模式可以避免序列化与反序列化破坏单例
         * 后面一部分则需要证明 普通的单例模式会被反序列化和序列化破坏
         */
        EnumInstance instance = EnumInstance.getInstance();
        instance.setData(new Object());
        // 序列化测试
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("EnumSingleton")));
        // 将对象持久化到文件中
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("EnumSingleton")));
        EnumInstance newInstance = (EnumInstance) ois.readObject();

        System.out.println(instance == newInstance);

        System.out.println(instance.getData());
        System.out.println(newInstance.getData());
        System.out.println(instance.getData() == newInstance.getData());

        // 获得单例对象
        SingletonDemo demo = SingletonDemo.getInstance();

        // 持久化到文件中
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(new File("SingletonDemo")));
        oos1.writeObject(demo);

        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(new File("SingletonDemo")));

        SingletonDemo demo1 = (SingletonDemo) ois1.readObject();
        System.out.println("测试反序列化能否破坏单例模式");
        System.out.println(demo == demo1);


//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);



    }
}
