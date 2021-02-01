package 贪心;

import java.util.Arrays;

/**
 * @author 彭一鸣 455. 分发饼干 https://leetcode-cn.com/problems/assign-cookies/
 * @since 2021/2/1 15:50
 */
public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        // 每次都发饼干给最小胃口的孩子
        for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
            if (s[i] >= g[j]) {
                ans++;
                j++;
            }
        }
        return ans;
    }
}
