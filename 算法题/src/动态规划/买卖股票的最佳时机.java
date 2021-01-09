package 动态规划;

/**
 * @author 彭一鸣 121. 买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @since 2021/1/9 16:15
 */
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        // 转移方程 f(n)为第n + 1天的最大收益 f(n) = Max[f(n - 1), n - min(i)]
        int[] f = new int[prices.length];
        f[0] = 0;
        int min = prices[0];
        for (int i = 1; i < f.length; i++) {
            f[i] = Math.max(f[i - 1], prices[i] - min);
            if (prices[i] < min) min = prices[i];
        }
        return f[f.length - 1];
    }
}
