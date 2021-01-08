package 动态规划;

/**
 * @author 彭一鸣  64. 最小路径和   https://leetcode-cn.com/problems/minimum-path-sum/
 * @since 2020/12/22 15:40
 */
public class 最小路径和 {
    public int minPathSum(int[][] grid) {
        // 转移方程 f[i][j] = min(f[i - 1][j], f[i][j - 1]) + grid[i][j]
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                if (i != 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
                if (i != 0 && j != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
