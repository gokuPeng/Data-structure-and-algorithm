package 动态规划;

import java.util.Arrays;

/**
 * @author 彭一鸣 132. 分割回文串 II https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * @since 2021/1/26 9:13
 */
public class 分割回文串II {
    public int minCut(String s) {
        int length = s.length();
        boolean[][] g = new boolean[length][length];
        for (boolean[] b : g) {
            Arrays.fill(b, true);
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                g[i][j] = g[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < length; i++) {
            if (g[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (g[j + 1][i]) {
                        dp[i] = Math.min(dp[j] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[length - 1];
    }
}
