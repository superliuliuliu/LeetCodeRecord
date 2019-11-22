package com.designpattern.creational.abstractfactory;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description java笔记
 * @date 2019/11/18 19:30
 */
public class JavaArticle extends Article{
    @Override
    public void produce() {
        System.out.println("记录java学习笔记");
    }
}
