package com.designpattern.creational.simplefactory;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description python视频
 * @date 2019/11/11 16:35
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Python视频");
    }
}
