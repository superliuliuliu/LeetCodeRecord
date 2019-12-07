package com.designpattern.creational.builder;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 课程抽象建造者
 * @date 2019/12/5 16:15
 */
public abstract class CourseBuilder {

    public abstract void buildCourseName(String courseName);

    public abstract void buildCoursePPT(String coursePPT);

    public abstract void buildCourseVideo(String courseVideo);

    public abstract void buildCourseArticle(String courseArticle);

    public abstract void buildCourseQA(String courseQA);

    public abstract Course makeCourse();
}
