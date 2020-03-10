package com.imooc.algorithm.sort;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 插入排序
 * @date 2020/3/9 0:01
 */
public class InsertSort {

    /**
     * insertSort
     * @description 插入排序
     * 核心思想：将数组划分为已排序和未排序区间  已排序区间初始只有一个元素 ，然后将未排序区间的元素一个个插入已排序区间 直至未排序区间为空
     * @param nums
     * @return {@link }
     * @author liugaoyang
     * @date 2020/3/9 0:01
     * @version 1.0.0
     */
    public static int[] insertSort(int[] nums){
        if (nums.length <= 1){
            return nums;
        }
        // 遍历未排序区间
        for (int i = 1; i < nums.length; i++){
            int value = nums[i];
            int j = i - 1;
            // 遍历排序区间 查找插入的位置
            for(; j >= 0; j--){
                if (nums[j] > value){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            nums[j+1] = value;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,3,2,1};
        insertSort(nums);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

    }
}
