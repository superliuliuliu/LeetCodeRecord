package com.leetcode.Date0820;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @description 给定一个数组，求出其中三个数之和为0的所有组合，组合中的元素不能重复
 * @author liugaoyang
 * @date 2019/8/20 17:13
 * @version 1.0.0
 */
public class ThreeSum {

    public static void main(String[] args) {
        int a = 2;
        int b = -a;
        System.out.println(b);
    }

    //nums = [-1, 0, 1, 2, -1, -4]，
    //
    //满足要求的三元组集合为：
    //[
    //  [-1, 0, 1],
    //  [-1, -1, 2]
    //]

    // 提供的数组是无序数组
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return result;
        }
        // 对数组进行排序 得到的时候升序数组
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2; i++){
            // 若最小的数大于0则一定不存在
            if (nums[i] > 0){
                break;
            }
            // 若数字重复 则需要去除重复
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            //l < r 表示还有元素存在
            while (l < r){
                // 判断边界条件 当最大值为负数时跳出此次判断
                if (nums[r] < 0){
                    break;
                }
                if (nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }
                else if(nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                }
                else{
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去除重复数据的情况
                    while (l < r && nums[l]==nums[l+1]){
                        l++;
                    }
                    while (l < r && nums[r]==nums[r-1]){
                        r--;
                    }
                    // 程序继续进行
                    l++;
                    r--;
                }
            }
        }
        return result;
    }
}
