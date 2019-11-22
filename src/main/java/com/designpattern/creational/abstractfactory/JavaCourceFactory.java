package com.designpattern.creational.abstractfactory;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description java课程工厂类
 * @date 2019/11/18 19:28
 */
public class JavaCourceFactory implements CourceFactory{
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
