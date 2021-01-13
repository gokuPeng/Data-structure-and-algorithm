package 动态规划;

/**
 * @author 彭一鸣 714. 买卖股票的最佳时机含手续费 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @since 2021/1/9 16:37
 */
public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int fx = 0; // 第一天没股票时手里的收益
        int fy = -prices[0]; // 第一天手里有股票时的收益
        for (int i = 0; i < prices.length; i++) {
            int temp = fx;
            fx = Math.max(fy + prices[i], fx);
            fy = Math.max(fy, temp - prices[i] - fee);
        }
        return Math.max(fx, fy);
    }
}
