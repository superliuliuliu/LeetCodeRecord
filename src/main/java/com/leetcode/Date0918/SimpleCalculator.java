package com.leetcode.Date0918;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 计算表达式的值
public class SimpleCalculator {

    Stack<Integer> dataStack;
    Stack<Character> characterStack;

    public Integer getResult(String expr){
        dataStack = new Stack<>();
        characterStack = new Stack<>();
        Map<Character, Integer> priority = new HashMap<>();
        // + - 操作优先级设为1 乘和除设置为2
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);

        for (int i = 0; i < expr.length(); i++){
            // 表示是操作符
            if (expr.charAt(i)=='*'||expr.charAt(i)=='+'||expr.charAt(i)=='-'|| expr.charAt(i)=='/'){
                if (characterStack.isEmpty()){
                    // 如果是第一个操作符 则入栈
                    characterStack.push(expr.charAt(i));
                }// 如果不是第一个操作符 则比较栈顶操作符 与当前操作符的优先级
                else if(priority.get(expr.charAt(i)) < priority.get(characterStack.peek())){
                    Character a = characterStack.pop();
                    characterStack.push(expr.charAt(i));
                    int num1 = dataStack.pop();
                    int num2 = dataStack.pop();
                    if (a == '*'){
                        dataStack.push(num1 * num2);
                    }else{
                        dataStack.push(num1 / num2);
                    }
                }else{
                    characterStack.push(expr.charAt(i));
                }
            }// 读进来的是操作数
            else{
                dataStack.push(expr.charAt(i) - '0');
            }
        }
        int value = 0;
        while (!characterStack.isEmpty()){
            int num1 = dataStack.pop();
            int num2 = dataStack.pop();
            if (characterStack.peek()=='+'){
                value = num1 + num2;
            }else if(characterStack.peek()=='-'){
                value = num2 - num1;
            }else if(characterStack.peek()=='*'){
                value = num1 * num2;
            }else {
                value = num2 / num1;
            }
            characterStack.pop();
            dataStack.push(value);
        }
        return dataStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new SimpleCalculator().getResult("1+2*5*9"));
    }
}
