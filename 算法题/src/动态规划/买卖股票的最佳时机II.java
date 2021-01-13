package 动态规划;

/**
 * @author 彭一鸣 122. 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @since 2021/1/12 18:00
 */
public class 买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int fx = 0; // 第一天没股票时手里的收益
        int fy = -prices[0]; // 第一天手里有股票时的收益
        for (int i = 0; i < prices.length; i++) {
            int temp = fx;
            fx = Math.max(fy + prices[i], fx);
            fy = Math.max(fy, temp - prices[i]);
        }
        return Math.max(fx, fy);
    }
}
