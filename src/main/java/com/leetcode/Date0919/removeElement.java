package com.leetcode.Date0919;

// leetcode 27移除元素
// 与快慢指针相同的思路 慢指针指向结果
public class removeElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null){
            return 0;
        }
        //使用快慢指针
        int slow = 0;
        int fast = 0;
        for(fast = 0; fast < nums.length; fast++){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;

    }
}
