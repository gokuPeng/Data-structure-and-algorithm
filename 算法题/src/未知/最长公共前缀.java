package 未知;

/**
 * @author 彭一鸣  14. 最长公共前缀    https://leetcode-cn.com/problems/longest-common-prefix/
 * @since 2020/12/23 15:04
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int k;
        a:
        for (k = 0; ; k++) {
            char c;
            if (strs.length == 0 || strs[0].length() == k) {
                break;
            } else {
                c = strs[0].charAt(k);
            }
            for (int i = 0; i < strs.length; i++) {
                // 如果有人到头了，结束
                if (strs[i].length() == k) {
                    break a;
                }
                // 如果有不匹配的，结束
                if (c != strs[i].charAt(k)) {
                    break a;
                }
            }
        }
        return strs.length == 0 || strs[0].length() == 0 ? "" : strs[0].substring(0, k);
    }
}
