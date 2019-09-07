package com.leetcode.Date0904;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @description 携程笔试之反转字符串
 * @author liugaoyang
 * @date 2019/9/5 13:09
 * @version 1.0.0
 */
public class XTMain1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        Stack stack1 = new Stack();
        // 用来储存 右括号前的字符串长度 保证只反转括号内的内容
        Stack<Integer> stack2 = new Stack<>();
        StringBuilder res = new StringBuilder();
        Map<Character, Character> stock = new HashMap<>();
        stock.put(')', '(');

        for (int i = 0; i < expr.length(); i++){
            // 右括号入栈1
            if (expr.charAt(i)== '('){
                // 右括号入栈后 要先统计一下之前的字符串的长度 保证只反转括号内的字符
                stack1.push(expr.charAt(i));
                // 之所以使用栈的形式存储 因为也是先进后出的特点
                stack2.push(res.toString().length());

            }// 当为左括号时
            else if(expr.charAt(i) == ')'){
                // 先看栈1是否为空 如果栈1为空的话 返回空字符串 或者栈顶的括号不匹配
                if (stack1.empty() || stack1.peek() != stock.get(expr.charAt(i))){
                    // 不符合条件返回空字符串
                    return "";
                }
                // 满足则弹出栈顶元素
                stack1.pop();
                // 当弹出一次左扩号时 反转一次字符串 这里有一点问题 并不应该反转所有的字符串
                int length = stack2.pop();
                // 括号内的字符
                String str = res.substring(length, res.toString().length());
                // 拼接字符串 得到反转操作的字符
                res = new StringBuilder(res.substring(0, length)).append(new StringBuilder(str).reverse());
            }else{
                // 字母则拼接如字符
                res.append(expr.charAt(i));
            }
        }
        if (stack1.empty()){
            return res.toString();
        }
        return "";

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        String s = "xa";
        System.out.println(s.substring(1,2));
        System.out.println(s.substring(0,1));

        System.out.println(resolve("u(r)"));
    }
}
