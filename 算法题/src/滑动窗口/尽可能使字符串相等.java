package 滑动窗口;

/**
 * @author 彭一鸣 1208. 尽可能使字符串相等 https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 * @since 2021/2/5 11:50
 */
public class 尽可能使字符串相等 {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int[] cost = new int[s.length()];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Math.abs(a[i] - b[i]);
        }
        int left = 0, right = 0;
        int max = 0;
        int curCost = 0;
        while (right < cost.length) {
            curCost += cost[right];
            while (curCost > maxCost) {
                curCost -= cost[left];
                left++;
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }
}
