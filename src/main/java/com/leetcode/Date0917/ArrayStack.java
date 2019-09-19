package com.leetcode.Date0917;

// 使用数组实现一个栈
public class ArrayStack {

    // 栈中元素数目统计
    private int count;

    // 用于存储栈中的元素
    private String[] items;

    // 栈的容量
    private int n;

    public ArrayStack(int n){
        this.count = 0;
        items = new String[n];
        this.n = n;
    }

    public boolean push(String x){
        // 已无空闲空间
        if (count == n) return false;

        items[count] = x;
        count++;
        return true;
    }

    public String pop(){
        if (count == 0) throw new RuntimeException("your stack is empty");
        String tmp = items[count-1];
        count--;
        return tmp;
    }
}
