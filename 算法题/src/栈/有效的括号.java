package 栈;

import java.util.Stack;

// 20. 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
public class 有效的括号 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.empty()) {
                stack.push(chars[i]);
                continue;
            }
            if (chars[i] == stack.peek()) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        for (Character character : stack) {
            System.out.println(character);
        }
        return stack.empty();
    }
}
