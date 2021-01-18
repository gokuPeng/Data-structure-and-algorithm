package 动态规划;

/**
 * @author 彭一鸣 123. 买卖股票的最佳时机 III https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @since 2021/1/18 11:46
 */
public class 买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        // 1、状态
        // s1:第一次有股票，s2:第二次有股票，s3无股票买过一次,s4无股票买过两次
        // s1 = Max(s1, - prices[i])
        // s2 = Max(s2, s3 - prices[i])
        // s3 = Max(s1 + prices[i], s3)
        // s4 = Max(s2 + prices[i], s4)
        int s1 = -prices[0], s2 = -prices[0];
        int s3 = 0, s4 = 0;
        for (int i = 1; i < prices.length; i++) {
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s3 - prices[i]);
            s3 = Math.max(s1 + prices[i], s3);
            s4 = Math.max(s2 + prices[i], s4);
        }
        return s4;
    }
}
