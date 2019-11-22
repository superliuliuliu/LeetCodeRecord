package com.designpattern.creational.factorymethod;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description python视频工厂类
 * @date 2019/11/18 16:17
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
