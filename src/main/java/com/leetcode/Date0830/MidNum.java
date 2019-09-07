package com.leetcode.Date0830;


import java.util.Arrays;

public class MidNum {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null){
            return 0;
        }
        // 求两个有序数组的中位数问题 归根结底该问题 是将两个数组重新排序 然后求中位数
        int len1 = nums1.length;
        int len2 = nums2.length;
        double[] result = new double[len1 + len2];

        // 排除几个特殊情况
        if (nums1[nums1.length - 1] < nums2[0]){
            for (int i = 0; i < nums1.length; i++){
                result[i] = nums1[i];
            }
            for (int i = nums1.length; i< nums1.length + nums2.length; i++){
                int j = 0;
                result[i] = nums2[j];
                j++;
            }
        }
        else if (nums2[nums2.length - 1] < nums1[0]){
            for (int i = 0; i < nums2.length; i++){
                result[i] = nums2[i];
            }
            for (int i = nums2.length; i< nums1.length + nums2.length; i++){
                int j = 0;
                result[i] = nums1[j];
                j++;
            }
        }
        else {
            for (int i = 0; i < nums1.length; i++){
                result[i] = nums1[i];
            }
            for (int i = nums1.length; i< nums1.length + nums2.length; i++){
                int j = 0;
                result[i] = nums2[j];
                j++;
            }
            Arrays.sort(result);
        }
        // 选择将数量少的数组插入数量多的数组之中
        // 判断m+n是奇数还是偶数  奇数的话中位数为   偶数的话中位数为
        if ((len1 + len2) % 2 > 0){
            return result[(len1 + len2)/2];
        }else {
            return (result[(len1 + len2)/2] + result[(len1 + len2)/2-1])/2;
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length==0 && nums2.length == 0){
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        System.out.println((i+j)/2);
    }
}
