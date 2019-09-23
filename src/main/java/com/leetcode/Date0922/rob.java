package com.leetcode.Date0922;

// leetcode 198打劫
public class rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        if (len == 2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[0]>nums[1]?nums[0]:nums[1];
        for (int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[len-1];
    }
}
