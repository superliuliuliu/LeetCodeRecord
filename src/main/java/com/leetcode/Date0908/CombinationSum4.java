package com.leetcode.Date0908;

import java.util.Arrays;

// leetcode 377
// 使用回溯算法暂时超时  后续使用动态规划来求解
public class CombinationSum4 {
    private int result;

    // 求给定目标的组合的个数问题
    public int combinationSum4(int[] nums, int target) {
        result = 0;
        if (nums == null){
            return result;
        }
//        Arrays.sort(nums);
        getCombinationSum4(target, nums);
        return result;
    }


    private void getCombinationSum4(int remain, int[] nums){
        if (remain == 0){
            result++;
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (remain - nums[i] >= 0){
                getCombinationSum4(remain - nums[i], nums);
            }else{
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,4};
        CombinationSum4 c = new CombinationSum4();
        c.combinationSum4(nums, 4);
        System.out.print(c.result);
    }
}
