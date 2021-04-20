package 字符串;

/**
 * @author 彭一鸣 28. 实现 strStr() https://leetcode-cn.com/problems/implement-strstr/
 * @since 2021/4/20 14:54
 */
public class 实现strStr {
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int n = haystack.length();
        int m = needle.length();
        // 计算next数组
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            // 一直找到应该匹配的
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            // 此时应该拿这个字符和主字符串匹配
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aaabbaba";
        String needle = "aaabbab";
        System.out.println(strStr(haystack, needle));
    }
}
