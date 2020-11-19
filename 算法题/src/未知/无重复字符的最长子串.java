package 未知;

import java.util.HashSet;

/**
 * @author 彭一鸣  3. 无重复字符的最长子串
 * @since 2020/11/19 14:32 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            int curMax = 0;
            HashSet<Character> set = new HashSet<>();
            int setNum = 0;
            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                setNum++;
                if (set.size() == setNum) {
                    curMax++;
                } else {
                    break;
                }
            }
            if (curMax > max) max = curMax;
        }
        return max;
    }
}
