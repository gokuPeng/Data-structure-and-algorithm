package 双指针;

/**
 * @author 彭一鸣 28. 实现 strStr() https://leetcode-cn.com/problems/implement-strstr/
 * @since 2021/1/4 17:01
 */
public class 实现strStr {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        int x = -1;
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[0]) {
                // 如果相等了就判断是不是相等
                boolean flag = true;
                for (int j = 0, k = i; j < b.length; j++, k++) {
                    if (k > a.length - 1 || a[k] != b[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return x;
    }
}
