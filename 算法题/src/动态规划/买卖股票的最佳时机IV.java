package 动态规划;

import java.util.Arrays;

/**
 * @author 彭一鸣 188. 买卖股票的最佳时机 IV https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * @since 2021/1/18 16:46
 */
public class 买卖股票的最佳时机IV {
    // 1、定义状态
    // dp[i][0][m] 第i天手里没股票，一共完成了m次交易
    // dp[i][1][m] 第i天手里有股票，一共完成了m次交易
    // 2、状态方程
    // dp[i][0][m] = Max(dp[i - 1][0][m], dp[i - 1][1][m - 1] + prices[i])
    // dp[i][1][m] = Max(dp[i - 1][1][m], dp[i - 1][0][m] - prices[i])
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        int[][][] dp = new int[prices.length][2][k + 1];
        for (int i = 0; i < k; i++) {
            dp[0][1][i] = -prices[0];
            dp[i][1][0] = -prices[0];
        }
        dp[k][1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);
            }
        }
        return dp[prices.length - 1][0][k];
    }
}
