package com.designpattern.creational.builder;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 课程建造者
 * @date 2019/12/5 16:20
 */
public class CourseActualBuilder extends CourseBuilder{

    private Course course = new Course();

    @Override
    public void buildCourseName(String courseName) {
        this.course.setCourseName(courseName);
    }

    @Override
    public void buildCoursePPT(String coursePPT) {
        this.course.setCoursePPT(coursePPT);

    }

    @Override
    public void buildCourseVideo(String courseVideo) {
        this.course.setCourseVideo(courseVideo);

    }

    @Override
    public void buildCourseArticle(String courseArticle) {
        this.course.setCourseArticle(courseArticle);

    }

    @Override
    public void buildCourseQA(String courseQA) {
        this.course.setCourseQA(courseQA);
    }

    @Override
    public Course makeCourse() {
        return course;
    }
}
