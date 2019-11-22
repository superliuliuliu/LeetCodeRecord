package com.designpattern.creational.simplefactory;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2019/11/11 16:36
 */
public class Test {

    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo("java");
        JavaVideo javaVideo = (JavaVideo) VideoFactory.getVideoByClass(JavaVideo.class);
        javaVideo.produce();
    }
}
