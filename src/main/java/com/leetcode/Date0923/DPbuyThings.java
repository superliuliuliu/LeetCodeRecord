package com.leetcode.Date0923;

// 购买商品
/*
淘宝的“双十一”购物节有各种促销活动，比如“满200元减50元”。假设你女朋友的购物车中有n个 （n>100）想买的商品，
她希望从里面选几个，在凑够满减条件的前提下，让选出来的商品价格总和最大程 度地接近满减条件（200元），
这样就可以极大限度地“薅羊毛”。作为程序员的你，能不能编个代码来帮 她搞定呢？
要求当商品的价值和大于3w时失去了薅羊毛的必要，w代表满减的标准  要求输出需要购买商品的价值
 */
public class DPbuyThings {

    // w 代表满减的门槛值
    private void buyWhat(int[] items, int w){
        // 购物车中商品的件数
        int n = items.length;
        // 状态转移表格
        boolean[][] prices = new boolean[n][3*w+1];

        // 初始化状态转换表格第一行
        prices[0][0] = true;
        prices[0][items[0]] = true;

        for (int i = 1; i < n; i++){
            for (int j = 0; j <= 3 * w; j++){
                // 判断上一个阶段的状态是否为使用过
                if (prices[i-1][j] == true){
                    // 不选择本商品
                    prices[i][j] = true;
                    // 选择本商品 需要注意防止数组越界
                    if ((j + items[i]) <= 3*w){
                        prices[i][j+items[i]] = true;
                    }
                }
            }
        }
        // 开始输出解
        int min = w;
        // 找到一个购买的最接近200的值
        for (min = w; min <= 3*w; min++){
            if (prices[n-1][min] == true){
                break;
            }
        }
        if (min == 3*w + 1) return;
        System.out.println("购物车总价值（未使用优惠券）："+ min +"元");
        for (int i = n - 1; i >= 1; i-- ){
            if (min-items[i] >=0 && prices[i][min-items[i]] == true){
                System.out.println(items[i]);
                min = min - items[i];
            }
        }
        if (min > 0){
            System.out.println(items[0]);
        }

    }

}
