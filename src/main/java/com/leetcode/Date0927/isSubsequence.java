package com.leetcode.Date0927;

// leetcode 329判断是否是子序列
public class isSubsequence {

    // 方法1 使用动态规划效率并不高
    public boolean isSubsequence(String s, String t) {
        // 转化求最长公共子序列 然后比较长度即可
        int sourceLen = s.length();
        int targetLen = t.length();
        // 排除特殊情况
        if (sourceLen == 0){
            return true;
        }
        if (targetLen == 0){
            return false;
        }

        char[] source = s.toCharArray();
        char[] target = t.toCharArray();

        int[][] dp = new int[sourceLen][targetLen];
        // 初始化动态转移表
        for (int i = 0; i < targetLen; i++){
            if (source[0] == target[i]){
                dp[0][i] = 1;
            }else if(i != 0){
                dp[0][i] = dp[0][i-1];
            }else{
                dp[0][i] = 0;
            }
        }
        for (int i = 0; i < sourceLen; i++){
            if (target[0] == source[i]){
                dp[i][0] = 1;
            }else if (i!=0){
                dp[i][0] = dp[i-1][0];
            }else{
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i < sourceLen; i++){
            for (int j = 1; j < targetLen; j++){
                if (source[i] == target[j]){
                    dp[i][j] = getMAX(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]+1);
                }else{
                    dp[i][j] = getMAX(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
                }
            }
        }
        if (dp[sourceLen-1][targetLen-1] == sourceLen){
            return true;
        }
        return false;

    }

    private int getMAX(int a, int b, int c){
        int max = a;
        if (b > max){
            max = b;
        }
        if (c > max){
            max = c;
        }
        return max;
    }

    // 方法2 执行时间0ms 效率较高
    // 关键点在于理清了问题的本质  遍历s 去t中找看是否有对应的字符 若有返回对应的下标 index,下个字符从index+1开始寻找
    // 方法很是巧妙
    private boolean isadsfklasf(String s, String t){
        int sourceLen = s.length();
        int targetLen = t.length();
        // 排除特殊情况
        if (sourceLen == 0){
            return true;
        }
        if (targetLen == 0){
            return false;
        }
        //
        int index = -1;
        for (char c: s.toCharArray()){
            // index代表上个字母在t中的下标
            index = t.indexOf(c, index+1);
            if (index == -1){
                return false;
            }
        }
        return true;
    }
}
