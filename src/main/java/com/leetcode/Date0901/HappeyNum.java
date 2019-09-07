package com.leetcode.Date0901;

// LeetCode 202 快乐数问题
public class HappeyNum {
    // 判定一个数是否是快乐数  是判断链表中是否有环问题的变种  我们可以把每个结果看成一个节点 当出现环时 说明是快乐数
    public static boolean isHappy(int n) {
        if (n <= 0){
            return false;
        }
        int fast = getNext(getNext(n));
        int slow = getNext(n);
        // 尝试使用快慢指针来解决
        // 要想该数字是快乐数 则最后求出的结果中 只能有一个1、n个0
        while (fast != slow){
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }
        if (fast == 1){
            return true;
        }
        return false;
    }

    // 获取该数字的 这里传进来的n为正整数
    private static int getNext(int n){
        int result = 0;
        while (n > 0){
            result += (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(21));
    }


}
