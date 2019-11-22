package com.leetcode.Date0929;

import java.util.Arrays;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description
 * @date 2019/11/8 19:39
 */
public class heapsort
{
    /**
     * 交换数组中两个元素的位置
     * @author superliuliuliu1
     * @version 1.0
     * @param   array     一个序列 以数组形式存储
     * @param   a         待交换元素的索引
     * @param   b         待交换元素的索引
     */
    public static void swap(int[] array, int a, int b)
    {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
        return;
    }

    /**
     * 对堆进行调整，使其满足大顶堆的要求
     * @author superliuliuliu1
     * @version 1.0
     * @param   array     存储堆元素的数组
     * @param   index     待检验调整元素的索引
     * @param   len       堆中的元素数目
     */
    public static void maxheap(int[] array, int index, int len)
    {
        // 左、右子节点的索引
        int li = (index << 1) + 1;
        int ri = li + 1;
        // 左右子节点相比较 较大节点的索引  默认设置为左节点
        int maxi = li;

        if (li > len - 1) return;
        if (ri <= len - 1 && array[ri] > array[li])
        {
            maxi = ri;
        }

        if (array[maxi] > array[index])
        {
            swap(array, maxi, index);
            maxheap(array, maxi, len); //检验交换后的节点是否满足大顶堆的要求
        }

    }

    /**
     * 对堆元素进行排序
     * @author superliuliuliu1
     * @version 1.0
     * @param   array     待排序的数组序列
     */
    public static void heapSort(int[] array)
    {
        //第一部分对其进行构建大顶堆操作
        for (int i = array.length/2 - 1; i >= 0; i--)
        {
            maxheap(array, i, array.length);
        }

        for (int j = array.length - 1; j > 0 ; j--)
        {
            swap(array, 0, j);
            maxheap(array, 0, j);
        }


    }
    /**
     * 对堆进行调整，使其满足小顶堆的要求
     * @author superliuliuliu1
     * @version 1.0
     * @param   array     存储堆元素的数组
     * @param   index     待检验调整元素的索引
     * @param   len       堆中的元素数目
     */
    public static void minheap(int[] array, int index, int len)
    {
        // 左、右子节点的索引
        int li = (index << 1) + 1;
        int ri = li + 1;
        if (li > len - 1) return;
        //mini为较小节点的索引默认设置为左节点
        int mini = li;

        if (ri <= len - 1 && array[ri] > array[li])
        {
            mini = ri;
        }

        if (array[mini] < array[index])
        {
            swap(array, mini, index);
            minheap(array, mini, len); //检验交换后的节点是否满足小顶堆的要求
        }

    }

    /**
     * 对堆元素进行排序
     * @author superliuliuliu1
     * @version 1.0
     * @param   array     待排序的数组序列
     */
    public static void heapSort1(int[] array)
    {
        //第一部分对其进行构建小顶堆操作
        for (int i = array.length/2 - 1; i >= 0; i--)
        {
            minheap(array, i, array.length);
        }

        for (int j = array.length - 1; j > 0 ; j--)
        {
            swap(array, 0, j);
            minheap(array, 0, j);
        }


    }



    public static void main(String[] args)
    {
        int [] arr = new int[]{20,25,20,40,33,10,430,10000,60};
        System.out.println("堆排序之前： "+ Arrays.toString(arr));
        int index= 0 ;
        int li = (index << 1) + 1;
        System.out.println(li);
        heapSort1(arr);
        System.out.println("堆排序之后： "+Arrays.toString(arr));

    }
}

