package com.leetcode.Date0917;

import java.util.Stack;

// leetcode 155 设计一个支持获取最小元素的栈
public class getMinStack {
    Stack<Integer> stackData;

    Stack<Integer> stackMin;

    /** initialize your data structure here. */
    public getMinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        // 先进入数据栈
        stackData.push(x);
        if (stackMin.isEmpty()){
            stackMin.push(x);
        }else{
            if (x <= this.getMin()){
                stackMin.push(x);
            }
        }
    }

    public void pop() {
        if (stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        int value = stackData.pop();
        if (value == stackMin.peek()){
            stackMin.pop();
        }

    }

    public int top() {
        if (stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return stackData.peek();
    }

    public int getMin() {
        if (stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return stackMin.peek();
    }
}
