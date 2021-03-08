package 数组;

/**
 * @author 彭一鸣 1551. 使数组中所有元素相等的最小操作数 https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal/
 * @since 2021/3/8 16:37
 */
public class 使数组中所有元素相等的最小操作数 {
    public int minOperations(int n) {
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            // 判断离中间值差多少
            ans += n - ((2 * i) + 1);
        }
        return ans;
    }
}
