package 动态规划;

/**
 * @author 彭一鸣 91. 解码方法 https://leetcode-cn.com/problems/decode-ways/
 * @since 2021/4/21 0:02
 */
public class 解码方法 {
    public int numDecodings(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int[] dp = new int[n];
        if (array[0] == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int a = (array[i] - '0') + (array[i - 1] - '0') * 10;
            int b = array[i] - '0';
            if (a > 9 && a <= 26) {
                dp[i] = i >= 2 ? dp[i - 2] : 1;
            }
            if (b > 0 && b <= 9) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
