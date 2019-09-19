package com.leetcode.Date0919;

//leetcode 26. 删除排序数组中的重复项
// 使用双指针解决此类问题  慢指针指向最终结果数组数据  快指针则用来遍历数据 ，当快指针指向的值与慢指针指向的数据一致的时候跳过
// 当快指针指向的数据与慢指针指向的数据不一致的时候说明需要修改数组 将慢指针+1 然后将快指针指向的值赋给慢指针
public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        if (nums == null){
            return result;
        }
        // 使用快慢指针来解决这个问题 慢指针指向不重复的数组数据
        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++){
            if (nums[fast] != nums[slow]){
                // 如果快指针指向的数不等于慢指针 则慢指针加1并将快指针的值赋给慢指针
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
