package com.basic.compare;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 待比较的学生类
 * @date 2020/2/25 10:59
 */
public class Student implements Comparable<Student>{

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    private int age;

    private String name;


    @Override
    public int compareTo(Student o) {
        int flag = name.compareTo(o.name);
        if (flag == 0){
            flag = this.age - o.age;
        }
        return flag;
    }
}
