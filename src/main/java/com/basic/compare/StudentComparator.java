package com.basic.compare;

import java.util.Comparator;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 学生类比较器
 * @date 2020/2/25 11:04
 */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        int flag = o1.getName().compareTo(o2.getName());
        if (flag == 0){
            flag = o1.getAge() - o2.getAge();
        }
        return flag;
    }
}
