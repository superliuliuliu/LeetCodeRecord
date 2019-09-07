package com.leetcode.Date0826;


import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    // 默认只认为队列1中有元素
    private Queue q1;

    int top;

    // 输出队列
    private Queue q2;

    public MyStack(){
        this.q1 = new LinkedList();
        this.q2 = new LinkedList();
        this.top = 0;
    }

    public void push(int x) {
        // 元素进入q1队列
        q1.offer(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 将元素从队列1移到队列2 最后时交换q1和q2队列保证 q2队列为空
        while (q1.size() > 1){
            //将q1队列中的元素除了保留最后一个其他全部出队
            top = (int) q1.poll();// top保存的是当前队列中最后一个元素的值
            q2.offer(top);
        }
        // 最后一个元素出队 但是不加入q2 作为返回值
        int result = (int) q1.poll();
        // 交换q1、q2
        q1 = q2;
        q2 = new LinkedList();
        // 返回最后一个元素
        return result;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.pop();
        myStack.pop();

    }
}
