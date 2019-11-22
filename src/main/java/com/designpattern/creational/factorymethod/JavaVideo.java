package com.designpattern.creational.factorymethod;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description java视频
 * @date 2019/11/11 16:34
 */
public class JavaVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制java视频");
    }
}
