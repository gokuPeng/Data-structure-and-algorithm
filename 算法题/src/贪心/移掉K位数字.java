package 贪心;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 彭一鸣  402. 移掉K位数字 https://leetcode-cn.com/problems/remove-k-digits/
 * @since 2021/2/4 11:47
 */
public class 移掉K位数字 {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack1 = new ArrayDeque<>(num.length());
        Deque<Character> stack2 = new ArrayDeque<>(num.length());
        char[] chars = num.toCharArray();
        for (char c : chars) {
            stack1.addFirst(c);
        }
        for (int i = 0; i < k; i++) {
            while (!stack1.isEmpty()) {
                if (stack1.size() == 1) {
                    // 最后一位数，直接移掉
                    stack1.removeLast();
                } else {
                    Character top = stack1.removeLast();
                    if (top <= stack1.getLast()) {
                        stack2.addLast(top);
                    } else {
                        break;
                    }
                }
            }
            while (!stack2.isEmpty()) {
                stack1.addLast(stack2.removeLast());
            }
            // 处理前导0
            while (!stack1.isEmpty()) {
                if (stack1.getLast() != '0') {
                    break;
                } else {
                    stack1.removeLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack1.isEmpty()) {
            sb.append(stack1.removeLast());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}