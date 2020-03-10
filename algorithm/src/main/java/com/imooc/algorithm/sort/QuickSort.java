package com.imooc.algorithm.sort;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 快速排序
 * @date 2020/3/9 10:38
 */
public class QuickSort {
    private static void quickSortC(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quickSortC(a, p, q - 1);
        quickSortC(a, q + 1, r);
    }

    public static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i = i + 1;
            }
        }
        swap(a, i, end);
        return i;
    }

    private static void swap(int[] a, int start, int end){

    }

}
