package 动态规划;

import java.util.Arrays;

/**
 * @author 彭一鸣 322. 零钱兑换 https://leetcode-cn.com/problems/coin-change/
 * @since 2021/1/25 16:40
 */
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        // 定义状态f[x]表示   x零钱，最少可以被多少个硬币兑换
        // 状态方程f[x] = min(f[x - coins[i]]) + 1
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int j = 0; j < coins.length; j++) {
                int lastMin = i - coins[j];
                if (lastMin >= 0 && dp[lastMin] >= 0) {
                    min = min > 0 ? Math.min(dp[lastMin] + 1, min) : dp[lastMin] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
