package com.basic.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description Java中支持引用传递吗？  当然不支持
 * @date 2020/3/2 16:13
 */
public class ReferenceTest {


    // java中存在引用传递与值传递
    // 基础类型都是值传递
    // 引用类型除了（不变类即String、Integer、Double外）都是引用传递
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list);
        String s = "我是刘高阳";
        System.out.println(s+"1");
        change(s,list);
        System.out.println(list);
        System.out.println(s+"4");

        System.out.println("验证java中存在引用传递");
        StringBuilder stringBuilder = new StringBuilder("刘高阳");
        change1(stringBuilder);
        System.out.println(stringBuilder);


        String s3 = new String("你好");
        change3(s3);
        System.out.println(s3);

    }

    static StringBuilder change1(StringBuilder stringBuilder){
        stringBuilder.append(1);
        return stringBuilder;
    }

    public static void change(String s, List<Integer> list){
        list.add(1);
        System.out.println(s+"2");
        s = "我不是刘高阳";
        System.out.println(s+"3");
    }

    public static void change3(String s){
        s.substring(0,1);
    }

}
