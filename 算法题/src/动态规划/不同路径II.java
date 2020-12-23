package 动态规划;

/**
 * @author 彭一鸣  63. 不同路径 II https://leetcode-cn.com/problems/unique-paths-ii/
 * @since 2020/12/22 15:19
 */
public class 不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i == 0 && j != 0) {
                        // 向下走
                        dp[i][j] = dp[i][j - 1];
                    }
                    if (j == 0 && i != 0) {
                        // 向右走
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (i != 0 && j != 0) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
