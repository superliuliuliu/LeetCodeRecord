package com.leetcode.Date0826;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Leetcode 20 判断字符串是否是有效的
public class IsStringValid {

    public static boolean isValid(String s) {
        // 声明一个栈
        Stack stack = new Stack();
        Map<Character, Character> stock = new HashMap<>();
        stock.put(']', '[');
        stock.put(')', '(');
        stock.put('}', '{');

        for (int i = 0; i < s.length(); i++){
            // 若是左括号则入栈
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '('){
                // 入栈
                stack.push(s.charAt(i));
            }// 说明是右括号
            else {
                // 取栈顶值  当栈顶值为空时 或者不匹配时说明 不是有效的直接返回false

                if (stack.peek() == null || stack.peek() != stock.get(s.charAt(i))){
                    return false;
                }
                // 匹配的情况弹出栈顶元素
                stack.pop();
            }
        }
        // 当栈为空的时候 说明字符串是有效的
        if (stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "[]";
        System.out.println(isValid(s));
    }
}
