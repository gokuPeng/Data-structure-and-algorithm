package 滑动窗口;

import java.util.HashMap;

/**
 * @author 彭一鸣 3. 无重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @since 2021/2/5 14:17
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        while (right < chars.length) {
            if (map.get(chars[right]) != null) {
                map.put(chars[right], map.get(chars[right]) + 1);
            } else {
                map.put(chars[right], 1);
            }
            // 当map的长度比窗口的长度小，说明有重复的元素
            while (map.size() < right - left + 1) {
                if (map.get(chars[left]) > 1) {
                    map.put(chars[left], map.get(chars[left]) - 1);
                } else {
                    map.remove(chars[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
