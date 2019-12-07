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
        EnumInstance instance = EnumInstance.getInstance();
        instance.setData(new Object());
        // 序列化测试
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("EnumSingleton")));
        // 将对象持久化到文件中
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("EnumSingleton")));
        EnumInstance newInstance = (EnumInstance) ois.readObject();

        System.out.println(instance.getData());
        System.out.println(newInstance.getData());
        System.out.println(instance.getData() == newInstance.getData());

//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);



    }
}
