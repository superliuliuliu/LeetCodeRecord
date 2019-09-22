package com.leetcode.Date0922;

// leetcode 63 不同路径2
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class uniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 利用动态规划的思想
        if (obstacleGrid[0][0] == 1){
            return 0;
        }

        int n = obstacleGrid.length;// 列数
        int m = obstacleGrid[0].length;// 行数

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < n; i++){
            if (obstacleGrid[i][0] != 1 && obstacleGrid[i-1][0] != 0){
                obstacleGrid[i][0] = 1;
            }else{
                obstacleGrid[i][0] = 0;
            }
        }
        for (int i = 1; i < m; i++){
            if (obstacleGrid[0][i] != 1 && obstacleGrid[0][i-1] != 0){
                obstacleGrid[0][i] = 1;
            }else{
                obstacleGrid[0][i] = 0;
            }
        }

        for (int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (obstacleGrid[j][i] == 0){
                    obstacleGrid[j][i] = obstacleGrid[j-1][i] + obstacleGrid[j][i-1];
                }else{
                    obstacleGrid[j][i] = 0;
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }
}
