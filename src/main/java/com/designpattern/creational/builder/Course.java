package com.designpattern.creational.builder;

import lombok.Data;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 建造者模式  课程类
 * @date 2019/12/5 16:13
 */
@Data
public class Course {
    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArticle;
    private String courseQA;
}
