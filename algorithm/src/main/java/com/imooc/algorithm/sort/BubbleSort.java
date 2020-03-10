package com.imooc.algorithm.sort;

import java.util.Arrays;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 冒泡排序 冒泡排序
 * @date 2020/3/8 23:19
 */
public class BubbleSort {

    static int[] bubbleSort(int[] nums){
        if (nums.length <= 1){
            return nums;
        }
        // 是否有冒泡操作
        boolean flag = false;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length - i - 1; j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            // 一次遍历若无冒泡操作 说明有序
            if (!flag){
                break;
            }
        }
        return nums;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,3,2,1};
        bubbleSort(nums);
        float a = 0.1f;
        float b = 0.2f;
        System.out.println(a+b);
        System.out.println(0.05 + 0.01);


    }
}
