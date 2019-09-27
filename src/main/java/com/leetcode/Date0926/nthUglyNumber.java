package com.leetcode.Date0926;

// leetcode 264 查找第n个丑数
// 使用三指针 ，
public class nthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = getMin(dp[i2] * 2, dp[i3] * 3, dp[i5] * 5);
            if (min == dp[i2] * 2) {i2++;}
            if (min == dp[i3] * 3) {i3++;}
            if (min == dp[i5] * 5) {i5++;}
            dp[i] = min;
        }

        return dp[n - 1];
    }

    private int getMin(int a, int b, int c){
        int min = a;
        if (b < min){
            min = b;
        }
        if (c < min){
            min = c;
        }
        return min;
    }
}
