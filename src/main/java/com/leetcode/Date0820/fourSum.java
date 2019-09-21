package com.leetcode.Date0820;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leetcode 18 四数和 思路 将四数和问题转换为三数和问题 遍历数组 将所有可能的前两个数的组合成一个数 当然是按照顺序来的
public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length < 4){
            return result;
        }
        // 数组升序排序
        Arrays.sort(nums);
        //求四数和为target的解
        for (int i = 0; i < nums.length - 3; i++){
            // 去重
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++){
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                // 转换为三数和问题
                int sum = target - nums[i] - nums[j];
                while(left < right){
                    if (nums[left] + nums[right] == sum){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[left] + nums[right] > sum){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
