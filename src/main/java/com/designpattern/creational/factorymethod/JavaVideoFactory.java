package com.designpattern.creational.factorymethod;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description java视频工厂类
 * @date 2019/11/18 16:16
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
