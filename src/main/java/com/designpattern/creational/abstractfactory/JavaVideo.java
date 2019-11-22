package com.designpattern.creational.abstractfactory;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description java视频
 * @date 2019/11/18 19:29
 */
public class JavaVideo extends Video{
    @Override
    public void produce() {
        System.out.println("录制Java视频");
        return ;
    }
}
