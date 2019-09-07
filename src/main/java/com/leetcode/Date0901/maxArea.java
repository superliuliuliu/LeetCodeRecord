package com.leetcode.Date0901;

public class maxArea {
    public int maxArea(int[] height) {
        if (height.length < 2){
            return 0;
        }
        // 思路一 暴力破解
        int result = 0;
        for (int i = 0; i < height.length - 1; i++){
            for (int j = i + 1; j < height.length; j++){
                int height1 = Math.min(height[i], height[j]);
                int s = height1 * (j - i);
                if (result < s){
                    result = s;
                }
            }
        }
        return result;
    }
    public int maxArea2(int[] height) {
        if (height.length < 2){
            return 0;
        }
        // // 思路一 暴力破解
        // int result = 0;
        // for (int i = 0; i < height.length - 1; i++){
        //     for (int j = i + 1; j < height.length; j++){
        //         int height1 = Math.min(height[i], height[j]);
        //         int s = height1 * (j - i);
        //         if (result < s){
        //             result = s;
        //         }
        //     }
        // }
        // return result;
        // 思路二：双指针解决该问题 移动长度较短的指针来遍历 根据短板效应 可知长度较小的边变化可能影响的程度更大
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r){
            maxArea = (Math.min(height[l], height[r]) * (r-l)) > maxArea ?(Math.min(height[l], height[r]) * (r-l)): maxArea;
            if (height[l] <= height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
