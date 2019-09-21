package com.leetcode.Date0919;

// leetcode 41第一个缺失的正数
/*
解题思路：
利用位图bitmap 利用坐标与元素的值关联起来
因为是第一个缺失的正数  所以数组(长度为n)中最大可能存在的正数为n 当数据为负数或者大于n的数时 对结果无影响
遍历数组 交换符合情况的数据  比如nums[0] = 3, 那么我们把nums[3-1] = 3; 把nums[0] = nums[3-1],
然后进行下一个 直至最后
然后遍历数组 如果存在num[i] != i+1 的情况说明缺是的正数为i+1
若都存在 说明缺是的正数为数组长度+1

 */
public class firstMissingPositive {
    // 找出其中没有出现的最小正整数 而nums数组中可能有负数

    // 思路 采用位图的思想 数组长度为n,则最大的元素为n,若数组的值大于n
    public int firstMissingPositive(int[] nums) {
        int result = 1;
        if (nums == null || nums.length == 0){
            return result;
        }
        // 利用bitmap的思想 将nums[i]移动到 nums[i] - 1的位置上  即1放在下标为0的位置上
        for (int i = 0; i < nums.length; i++){
            //
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void swap(int[] nums, int index1, int index2){
        if (index1 == index2){
            return;
        }
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
