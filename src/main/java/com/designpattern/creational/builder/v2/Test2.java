package com.designpattern.creational.builder.v2;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2019/12/5 17:17
 */
public class Test2 {

    public static void main(String[] args) {
        Course course = new Course.CourseBuilder()
                .buildCourseName("NAME")
                .buildCoursePPT("PPT")
                .build();
        System.out.println("course = " + course);
    }
}
