package com.leetcode.Date0826;

import java.util.Stack;

// 利用栈实现简单的队列
public class StackToQueue {


    private Stack stack1;

    private Stack stack2;

    /** Initialize your data structure here. */
    public StackToQueue() {
        this.stack1 = new Stack();
        this.stack2 = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 元素首选进入stack1中
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 执行一次操作 首先要看stack2中是否有元素
        // 如果stack2为空 则现将stack中的元素压入stack2
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
       return (int) stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        // 访问收个元素同理
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return (int) stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.empty()&&stack2.empty()){
            return true;
        }
        else{
            return false;
        }
    }
}
