package 动态规划;

import java.util.Arrays;

/**
 * @author 彭一鸣  5. 最长回文子串  https://leetcode-cn.com/problems/longest-palindromic-substring/submissions/
 * @since 2020/12/22 10:18
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        int max = 1;
        int m = 0;
        int n = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < dp.length; j++) {
                if (j - i >= 2) {
                    if (i + 1 <= dp.length - 2 && j - 1 >= 0) {
                        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                        if (dp[i][j] && j - i + 1 > max) {
                            max = Math.max(max, j - i + 1);
                            m = i;
                            n = j;
                        }
                    }
                } else if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if (dp[i][j] && j - i + 1 > max) {
                        max = Math.max(max, j - i + 1);
                        m = i;
                        n = j;
                    }
                }
            }
        }
        return s.substring(m, n + 1);
    }
}
