package 动态规划;

/**
 * @author 彭一鸣 309. 最佳买卖股票时机含冷冻期 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @since 2021/1/13 18:14
 */
public class 最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int s1 = 0, s2 = 0, s3 = 0, s4 = 0;
        if (prices.length < 2) {
            return 0;
        } else if (prices.length >= 2){
            s1 = Math.max(-prices[0], -prices[1]);
            s2 = prices[1] - prices[0];
        }
        if (prices.length >= 3) {
            int temp1 = s1;
            s1 = Math.max(s1, s4 - prices[2]);
            int temp2 = s2;
            s2 = temp1 + prices[2];
            s3 = temp2;
        }
        for (int i = 3; i < prices.length; i++) {
            int temp1 = s1;
            s1 = Math.max(Math.max(s1, s4 - prices[i]), s3 - prices[i]);
            int temp2 = s2;
            s2 = temp1 + prices[i];
            int temp3 = s3;
            s3 = temp2;
            s4 = Math.max(temp3, s4);
        }
        return Math.max(Math.max(s2, s3), s4);
    }
}
