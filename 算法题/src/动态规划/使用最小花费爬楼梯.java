package 动态规划;

/**
 * @author 彭一鸣  746. 使用最小花费爬楼梯  https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @since 2020/12/21 14:55
 */
public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int[] newCost = new int[cost.length + 1];
        int[] f = new int[newCost.length];
        System.arraycopy(cost, 0, newCost, 0, cost.length);
        f[0] = newCost[0];
        f[1] = Math.min(newCost[0], newCost[1]);
        for (int i = 2; i < newCost.length - 1; i++) {
            f[i] = Math.min(f[i - 1], f[i - 2]) + newCost[i];
        }
        return f[newCost.length - 1];
    }
}
