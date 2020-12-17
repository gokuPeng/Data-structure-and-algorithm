package 未知;

/**
 * @author 彭一鸣  714. 买卖股票的最佳时机含手续费  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @since 2020/12/17 18:58
 */
public class 买卖股票的最佳时机含手续费 {
    boolean flag = false;
    int lastBuy = 0;

    public int maxProfit(int[] prices, int fee) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (!flag) {
                boolean buy = isBuy(i, prices, fee);
                if (buy) {
                    flag = !flag;
                    ans -= prices[i];
                    lastBuy = prices[i];
                    System.out.println(lastBuy);
                }
            } else {
                boolean sale = isSale(i, prices, fee);
                if (sale) {
                    flag = !flag;
                    ans += prices[i] - fee;
                    System.out.println(prices[i]);
                } else {
                    if (prices[i] < lastBuy) {
                        ans += lastBuy - prices[i];
                        lastBuy = prices[i];
                    }
                }
            }
        }
        return flag ? ans + lastBuy : ans;
    }

    private boolean isBuy(int index, int[] prices, int fee) {
        for (int i = index + 1; i < prices.length; i++) {
            if (prices[i] <= prices[i - 1]) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean isSale(int index, int[] prices, int fee) {
        for (int i = index + 1; i < prices.length; i++) {
            if (prices[i] + fee > prices[i - 1] && prices[i - 1] >= prices[index]) {
                return false;
            } else {
                return true;
            }
        }
        if (flag) {
            if (prices[prices.length - 1] >= lastBuy + fee) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
