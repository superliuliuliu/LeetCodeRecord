package com.leetcode.Date0901;

public class findDuplicate {
    public int findDuplicate(int[] nums) {
        // 我的首先思路是现在是不允许使用额外的空间 那么我们就利用原有的数组 但是发现要求不允许修改数组内容
        // 暴力破解的话时间复杂度为o(n平方)
        // 现在估计的解法是快慢指针解法 将带有重复元素的数组看成一个链表 问题即转换为了求 环入口的位置
        if (nums == null || nums.length < 1){
            return 0;
        }
        // 其中 fast slow代表指针 而nums[i]的值为下一个元素的指针
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        // 找到了交点
        if (fast == slow){
            // 头节点的指针
            int head = 0;
            while (nums[head] != nums[fast]){
                // 遍历下一个元素
                head = nums[head];

                fast = nums[fast];
            }
            return nums[head];
        }
        return 0;
    }
}
