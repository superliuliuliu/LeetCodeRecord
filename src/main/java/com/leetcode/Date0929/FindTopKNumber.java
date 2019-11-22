package com.leetcode.Date0929;

import java.io.*;
import java.util.Arrays;

public class FindTopKNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File f1 = new File("E:\\JAVA\\Sort\\source.txt");
        int [] result = findTopKNumbers1(f1, 100);
        System.out.println("结果为："+ Arrays.toString(result));

    }


    /**
     * FindTopKNumbers
     *
     * @description 找出文件中数字里，最大的前N个数值
     * @param numberFile 存有数字的文件，每一行是一个int数字
     * @param topMax 要查最大的前多少个
     * @return 查出来的最大的前N个数值，倒序排列：
     * @author superliuliuliu1
     * @date 2019年2月12日 20:58
     * @version 1.0
     */
    public static int[] findTopKNumbers1(File numberFile, int topMax) {

        int[] result = new int[topMax];
        int ArrayIndex = 0;
        String str;
        int newelement;
        try {
            File f1 = new File("F:\\实习面试\\test.txt");
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));

            while ((str = bf.readLine())!= null)
            {
                //先读取100行数据构成一个数组
                if(ArrayIndex >= topMax) {
                    //当读够100行之后开始堆排序
                    heapSort(result);
                    newelement = Integer.valueOf(str);
                    //将第101 102行直至一亿行的数据依次与小顶堆的堆顶元素进行比较  若新读入的元素大于堆订元素，则置换元素，否则不进行操作
                    if (newelement > result[0])
                    {
                        result[0] = newelement;
                    }
                }
                else
                {
                    result[ArrayIndex] = Integer.valueOf(str);
                    ArrayIndex++;
                }

            }
            bf.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }

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
    public static void heapSort(int[] array)
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

}
