package 动态规划;

/**
 * @author 彭一鸣  62. 不同路径    https://leetcode-cn.com/problems/unique-paths/
 * @since 2020/12/22 14:29
 */
public class 不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // dp[0][0]，dp[m - 1][n - 1]
        // 转移方程f[x][y] = (f[x - 1]f[y]) + (f[x]f[y - 1])
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1];
                }
                if (j == 0 && i != 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (i != 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
