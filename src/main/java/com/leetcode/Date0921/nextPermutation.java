package com.leetcode.Date0921;

// 查找下一个更大的排列
/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
思路介绍
第一眼看到这道题时，我首先想到了回溯算法得到所有的字排列的情况，但是我很快就否定了这个方法
一开始时，我的想法是从数组尾部向前遍历，当遇到num[i-1]>nums[i]时就交换这两个元素的位置，但是经过进一步认真的思考我发现 上面的想法有很多漏洞
但是我思考了很长时间也没有找到合适的解法，最后我读了一遍题解，大致理解解法思想，然后我用我自己的方式实现如下：

这里主要介绍一下算法：
当数组元素 整体呈现降序排列时 说明此时数组的排列为最大的值，这时应对数组进行逆序处理即可得到结果
当数组元素无序排列，那么我们同样从数组尾部开始遍历，看数组元素是否满足num[i] <= nums[i-1]若满足我门让i--;继续（同时要注意防止数组越界i>0）
跳出上述while循环有两种可能，
第一种就是i=0,意味着整个数组已经遍历完并且数组呈现是降序的，我们只需要反转数组即可。
第二种就是存在nums[i] > nums[i-1]的情况 这意味着我们需要交换nums[i-1]与  数组下标范围为[i,nums.length-1]中的一个数组元素（这个数组元素是该范围内大于nums[i-1]的最小值）
交换了之后，并不代表结果就是正确的，因为我们把nums[i-1]换成了一个较大的值，而nums[i]~nums[len-1]还是呈现降序排列的，我们还需要反转这一部分，使其值最小，我在第一次的提交中就忽视了这个问题。
除了这个问题，还有一个需要注意的地方就是在寻找大于nums[i-1]的最小值时，即minMax >= nums[j] 我之前写的minMax > nums[j]导致第二次提交失败
 */
public class nextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int i = nums.length - 1;
        // 从数组尾部开始遍历  比如nums[5] < nums[4]时 i减一
        while(i > 0 && nums[i] <= nums[i - 1]){
            i--;
        }
        // i等于代表整个数组是逆序的 我们需要反转数组
        if (i == 0){
            // 反转数组即可
            reverse(nums, 0);
        }else if(i > 0){
            // 说明nums[i-1]>nums[i]
            // 遍历 i到nums.length-1 找到一个大于nums[i-1]的最小值
            int minMax = nums[i];
            int minIndex = i;
            for(int j = i; j < nums.length; j++){
                if (minMax >= nums[j] && nums[j] > nums[i-1]){
                    minMax = nums[j];
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i - 1);
            reverse(nums, i);
        }
        return;
    }

    // 反转数组 数组不为空的前提下
    private void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
        return;
    }

    private void swap(int[] nums, int index1, int index2){
        if (index1 == index2){
            return;
        }
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
        return;
    }
}
