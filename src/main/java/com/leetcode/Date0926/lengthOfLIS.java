package com.leetcode.Date0926;

import java.util.Arrays;

// leetcode 300 最长上升子序列长度
/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
思路
求解最长上升子序列的长度，这道问题是一道动态规划问题 我们要根据已知情况去推导未知情况，
思路是遍历数组 找到当前元素之前的小于该元素值的dp[index]值（最大dp值）+1
// 动态转移方程为
j满足的条件为 0<j<i,且nums[j]<nums[i]
dp[i]= Math.max(dp[j]+1, dp[i])
 */
public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {

        // 状态转移方程  dp[i] = max(dp[index]+1)
        // 其中index 为小于nums[i]的下标
        if (nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;

        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
