package 未知;

/**
 * @author 彭一鸣 1006. 笨阶乘 https://leetcode-cn.com/problems/clumsy-factorial/
 * @since 2021/4/1 22:05
 */
public class 笨阶乘 {
    public int clumsy(int N) {
        int ans = 0;
        int i = N;
        boolean flag = false;
        for (; i > 3; i = i - 4) {
            ans = !flag ? ans + (i * (i - 1) / (i - 2)) + (i - 3) : ans - (i * (i - 1) / (i - 2)) + (i - 3);
            flag = true;
        }
        if (i == 3) {
            ans = !flag ? ans + (i * (i - 1) / (i - 2)): ans - (i * (i - 1) / (i - 2));
        } else if (i == 2) {
            ans = !flag ? ans + (i * (i - 1)): ans - (i * (i - 1));
        } else if (i == 1) {
            ans = !flag ? ans + i : ans - i;
        }
        return ans;
    }
}
