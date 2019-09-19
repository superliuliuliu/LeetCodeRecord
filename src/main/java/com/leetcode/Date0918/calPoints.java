package com.leetcode.Date0918;

import java.util.Stack;

// leetcode 682
public class calPoints {
    private Stack<Integer> points;

    public int calPoints(String[] ops) {
        points = new Stack<>();

        for (int i = 0; i < ops.length; i++){
            if (ops[i].equals("C")){
                // 弹出元素
                points.pop();
            }else if(ops[i].equals("D")){
                points.push(points.peek()*2);
            }else if(ops[i].equals("+")){
                int a = points.pop();
                int b = points.peek();
                points.push(a);
                points.push(a+b);
            }else{
                points.push(Integer.parseInt(ops[i]));
            }
        }
        int result = 0;
        while (!points.isEmpty()){
            result += points.pop();
        }
        return result;
    }
}
