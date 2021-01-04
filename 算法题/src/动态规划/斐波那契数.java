package 动态规划;

/**
 * @author 彭一鸣 509. 斐波那契数 https://leetcode-cn.com/problems/fibonacci-number/solution/fei-bo-na-qi-shu-by-leetcode-solution-o4ze/
 * @since 2021/1/4 9:26
 */
public class 斐波那契数 {
    public int fib(int n) {
        // 转移方程 F(n) = F(n -  1) + F(n - 2)
        int[] f = new int[n + 1];
        if (n < 2) {
            return n;
        }
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
