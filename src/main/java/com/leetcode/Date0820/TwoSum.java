package com.leetcode.Date0820;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3};
        System.out.println(twoSumMedium(nums, 4));

    }

    // 这种解法好像没有考虑到hash碰撞的情况
    // 题目变种求解除所有的符合答案的下标地址 要求得到的结果不能重复
    public  static List<List<Integer>> twoSum(int[] nums, int target) {
        // 如果数组长度小于2返回空
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return result;
        }
        Map<Integer, Integer> data = new HashMap<>();
        // 将数据读取到HashMap中
        for (int i = 0; i < nums.length; i++) {
            data.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int another = target - nums[i];
            if (data.containsKey(another)){
                result.add(Arrays.asList(i, data.get(another)));
            }
        }
        return result;
    }

    // 性能更好的算法 减少数组的一次遍历
    public int[] twoSum2(int[] nums, int target) {
        // 如果数组长度小于2返回空
        int[] result = new int[2];
        if (nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> data = new HashMap<>();
        // 将数据读取到HashMap中
        for (int i = 0; i < nums.length; i++) {
            if (data.containsKey(nums[i])){
                result[0] = i;
                result[1] = data.get(nums[i]);
                return result;
            }
            // 以 <目标值，检测值的下标> 的形式存储到HashMap中
            data.put(target - nums[i], i);
        }
        return null;
    }

    // 题目升级要求计算出 所有满足答案  （不包含重复答案）
    public  static List<List<Integer>> twoSumMedium(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 2){
            return result;
        }
        // 排序
        Arrays.sort(nums);
        //
        for (int i = 0; i < nums.length-1; i++){
            // 跳过重复值
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int r = nums.length - 1;
            while (i < r){
                if (nums[i] + nums[r] == target){
                    result.add(Arrays.asList(nums[i], nums[r]));
                    while (i < r && nums[i] == nums[i+1]){
                        i++;
                    }
                    while (i < r && nums[r] == nums[r-1])
                    i++;
                    r--;
                }else if (nums[i] + nums[r] > target){
                    r--;
                }else if (nums[i] + nums[r] < target){
                    i++;
                }
            }
        }
        return result;
    }
}
