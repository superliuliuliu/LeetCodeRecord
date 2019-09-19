package com.leetcode.Date0919;

import java.util.Stack;

// leetcode 224基本计算器
public class calculate {
    // 思路利用两个栈来解决这个问题 栈1存储操作数 栈2存储操作符
    private Stack<Integer> dataStack;
    private Stack<Character> operatorStack;
    public int calculate(String s) {
        // 遇到（和 + -均入栈，遇到）操作符出栈 出一个操作符 出两个操作数 直至遇到左括号 计算结果后再将结果入操作数栈
        for (int i = 0; i < s.length(); i++){
            // 如果是空格的话不做处理
            if (s.charAt(i) == ' '){
                continue;
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'|| s.charAt(i) == '('){
                operatorStack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                // 出栈两个操作数
                while(operatorStack.peek() != '('){
                    int a = dataStack.pop();
                    int b = dataStack.pop();
                    Character operator = operatorStack.pop();
                    if (operator == '+'){
                        a = a + b;
                        dataStack.push(a);
                    }else{
                        a = b - a;
                        dataStack.push(a);
                    }
                }
                // 弹出（
                operatorStack.pop();
            }else{
                // 如果是数字的话 则进入数据栈
                dataStack.push(s.charAt(i) - '0');
            }
        }
        while (!operatorStack.isEmpty()){
            Character x = operatorStack.pop();
            int a = dataStack.pop();
            int b = dataStack.pop();
            if (x=='+'){
                dataStack.push(a+b);
            }else{
                dataStack.push(b-a);
            }
        }
        return dataStack.pop();
    }

    public static void main(String[] args) {
        String str = "1 + 1";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                continue;
            }
            stringBuilder.append(str.charAt(i));
        }
        System.out.println(stringBuilder.toString());
    }
}
