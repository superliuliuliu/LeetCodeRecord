package com.leetcode.Date0924;

import java.util.List;

// leetcode 120 三角形的最短路径和
public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null){
            return 0;
        }
        // height 为三角形的高度
        int height = triangle.size();
        // 下标为i的节点可以选择 i 和i+1的节点

        // 最顶行的元素不需要改变
        for(int i = 1; i < height; i++){
            // 第i行有i+1个节点
            List<Integer> num = triangle.get(i);
            // 上一行的数据
            List<Integer> preNum = triangle.get(i-1);
            for (int j = 0; j < i + 1 ; j++){
                if (j == 0){
                    num.set(j, num.get(j) + preNum.get(j));
                }else if(j == i){
                    num.set(j, num.get(j) + preNum.get(j-1));
                }
                else{
                    num.set(j, num.get(j)+Math.min(preNum.get(j), preNum.get(j-1)));
                }
            }
        }
        List<Integer> result = triangle.get(height-1);
        int min = result.get(0);
        for (int i = 0; i < result.size(); i++){
            if (min > result.get(i)){
                min = result.get(i);
            }
        }
        return min;
    }
}
