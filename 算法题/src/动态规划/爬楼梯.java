package 动态规划;

/**
 * @author 彭一鸣  70. 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/
 * @since 2020/12/22 15:51
 */
public class 爬楼梯 {
    public int climbStairs(int n) {
        // 转移方程 f[x] = f[x - 1] + f[x - 2] + 1;
        int[] f = new int[n];
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        f[0] = 1;
        f[1] = 2;
        f[2] = 3;
        for (int i = 3; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }
}
