package com.leetcode.Date0919;

// leetcode 53最大子序列的和
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null){
            return 0;
        }
        // 最终结果
        int res = nums[0];

        // sum代表前面子序列的和
        int sum = 0;

        // 若sum为负数 咋只会带来负面影响 所以将sum置为当前数组元素的值 若前面的sum为正数 则sum+=nums[i]
        for (int i = 0; i < nums.length; i++){
            if (sum < 0){
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            if (res < sum){
                res = sum;
            }
        }
        return res;
    }
}
