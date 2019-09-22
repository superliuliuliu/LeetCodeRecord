package com.leetcode.Date0922;

//leetcode 62 不同路径：
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
思路1：利用递归函数求解 （未AC 当数据量过大时超时 测试用例41超时 51列9行）
测试100,100花费时间为 我用IDE跑了好久都没跑出来

思路2：使用动态规划的思想

 */
public class uniquePaths {

    //解法1使用递归求解
//    private static int result;
//
//    public int uniquePaths(int m, int n) {
//        result = 0;
//        if (m == 0 || n == 0){
//            return result;
//        }
//        if (m == 1 || n == 1){
//            return 1;
//        }
//        getResult(0, 0, m-1, n-1);
//        // int i = 0;// 列数
//        // int j = 0;// 行数
//        return result;
//
//
//    }
//
//    // (i,j)代表当前数据的坐标 (m,n)终点的坐标
//    private void getResult(int i, int j, int m, int n){
//        if ((m - i) == 0 || (n - j) == 0){
//            return;
//        }else if ((m - i) == 1 && (n - j) == 1){
//            result += 2;
//        }else if ((m - i) == 1 && (n - j) != 1){
//            result += 1;
//            getResult(i, j + 1, m, n);
//        }else if ((m - i) != 1 && (n - j) == 1){
//            result += 1;
//            getResult(i + 1, j, m, n);
//        }else{
//            // 向下移动或者向右移动
//            getResult(i + 1, j, m, n);
//            getResult(i, j + 1, m, n);
//        }
//    }
//
//    public static void main(String[] args) {
//        Long old = System.currentTimeMillis();
//        System.out.println(new uniquePaths().uniquePaths(18, 18));
//        Long latest = System.currentTimeMillis();
//        System.out.println((latest-old)+ " ms");
//    }

    /*
    思路2 利用动态规划思想求解
    dp[i][j] 代表到达(i,j)可能的路径数目
    dp[0][i] = 1;
    dp[i][0] = 1;
    动态转换方程
    原因到达(i,j)只有两种可能 走（i-1,j）或者走（i, j-1）
    dp[i][j] = dp[i-1][j]+dp[i][j-1]
     */
    // 利用动态规划求解
    public int uniquePaths(int m, int n) {
        int result = 0;
        if (m == 0 || n == 0){
            return result;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
