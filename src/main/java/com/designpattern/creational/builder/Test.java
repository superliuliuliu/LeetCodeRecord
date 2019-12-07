package com.designpattern.creational.builder;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2019/12/5 16:29
 */
public class Test {
    public static void main(String[] args) {
        Coach coach = new Coach();
        CourseBuilder courseBuilder = new CourseActualBuilder();
        coach.setCourseBuilder(courseBuilder);
        Course course = coach.makeCourse("java并发",
                "PPT",
                "Video",
                "Article",
                "QA");
        System.out.println(course);
    }
}
