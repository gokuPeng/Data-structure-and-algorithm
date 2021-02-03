package 字符串;

/**
 * @author 彭一鸣 392. 判断子序列 https://leetcode-cn.com/problems/is-subsequence/
 * @since 2021/2/3 9:17
 */
public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
        char[] b = s.toCharArray();
        char[] a = t.toCharArray();
        // 记录搜索位置
        int cur = 0;
        for (int i = 0; i < b.length; i++) {
            boolean flag = false;
            // 对于b中的每一个字符，到a中从前往后搜索
            for (; cur < a.length; cur++) {
                if (b[i] == a[cur]) {
                    cur += 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
