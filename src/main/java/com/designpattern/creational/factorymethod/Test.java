package com.designpattern.creational.factorymethod;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2019/11/11 16:36
 */
public class Test {

    public static void main(String[] args) {
        JavaVideoFactory javaVideoFactory = new JavaVideoFactory();
        PythonVideoFactory pythonVideoFactory = new PythonVideoFactory();

        javaVideoFactory.getVideo().produce();
        pythonVideoFactory.getVideo().produce();
    }
}
