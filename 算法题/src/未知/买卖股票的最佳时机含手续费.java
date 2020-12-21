package 未知;

/**
 * @author 彭一鸣  714. 买卖股票的最佳时机含手续费  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @since 2020/12/17 18:58
 */
public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int ans = 0;
        int buyPoint = -1;
        int salePoint = -1;
        // 是否进行过购买
        int flag = 0;   // 0未购买1买了2卖了
        for (int i = 0; i < prices.length; i++) {
            // 买点
            // 如果是第一次直接买
            if (flag == 0) {
                buyPoint = i;
                ans -= prices[i];
                flag = 1;
                continue;
            } else if (flag == 1){
                // 如果买过了
                // 判断是不是价格更低
                if (prices[i] < prices[buyPoint]) {
                    // 如果价格更低则更换买点
                    ans += (prices[buyPoint] - prices[i]);
                    buyPoint = i;
                    continue;
                }
            } else {
                // 如果卖过了要比上次便宜fee块才能买
                if (prices[i] + fee < prices[salePoint]) {
                    flag = 1;
                    ans -= prices[i];
                    buyPoint = i;
                    continue;
                }
            }

            // 卖点
            if (flag == 1) {
                // 如果比买价+fee高直接卖
                if (prices[i] > prices[buyPoint] + fee) {
                    ans += (prices[i] - fee);
                    salePoint = i;
                    flag = 2;
                    System.out.println(salePoint);
                }
            } else if (flag == 2) {
                // 卖过了，如果遇到比上次高的卖点，取消上次卖点，这次再卖
                if (prices[i] > prices[salePoint]) {
                    ans += (prices[i] - prices[salePoint]);
                    salePoint = i;
                    flag = 2;
                }
            }
        }
        return flag == 1 ? ans + prices[buyPoint] : ans;
    }
}
