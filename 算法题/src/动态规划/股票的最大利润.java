package 动态规划;

import java.util.Arrays;

/**
 * @author 彭一鸣 剑指 Offer 63. 股票的最大利润 https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @since 2021/1/18 19:55
 */
public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        // 1、状态
        // 第i天有股票 a[i][1] = a[i - 1][1], 0 - prices[i]
        // 第i天没股票不能买 a[i][0] = a[i - 1][1], a[i][0]
        int[][] a = new int[2][prices.length];
        a[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            a[1][i] = Math.max(a[1][i - 1], 0 - prices[i]);
            a[0][i] = Math.max(a[1][i - 1] + prices[i], a[0][i]);
        }
        return Arrays.stream(a[0]).max().getAsInt();
    }
}
