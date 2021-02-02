package 贪心;

import java.util.*;

/**
 * @author 彭一鸣  316. 去除重复字母 https://leetcode-cn.com/problems/remove-duplicate-letters/
 * @since 2021/2/1 16:15
 */
public class 去除重复字母 {
    public String removeDuplicateLetters(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        // 维护出现的次数
        int[] times = new int[26];
        for (int i = 0; i < chars.length; i++) {
            times[chars[i] - 'a']++;
        }
        // 维护是否出现过
        boolean[] visited =  new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chars) {
            if (!visited[ch - 'a']) {
                while (!stack.isEmpty() && stack.getLast() > ch) {
                    if (times[stack.getLast() - 'a'] > 0) {
                        Character top = stack.removeLast();
                        visited[top - 'a'] = false;
                    } else {
                        break;
                    }
                }
                visited[ch - 'a'] = true;
                stack.addLast(ch);
            }
            times[ch - 'a'] -= 1;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
