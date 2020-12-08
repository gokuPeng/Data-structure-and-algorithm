package 栈;

import java.util.ArrayDeque;

/**
 * @author 彭一鸣 32. 最长有效括号 https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @since 2020/12/8 18:01
 */
public class 最长有效括号 {
    private class myMap {
        private Integer index;
        private Character character;

        public myMap(Integer index, Character character) {
            this.index = index;
            this.character = character;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Character getCharacter() {
            return character;
        }

        public void setCharacter(Character character) {
            this.character = character;
        }
    }
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        ArrayDeque<myMap> stack = new ArrayDeque<>();
        boolean[] used = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            myMap peek = stack.peek();
            if (peek != null && '(' == peek.getCharacter()  && s.charAt(i) == ')') {
                myMap pop = stack.pop();
                used[pop.getIndex()] = true;
                used[i] = true;
            } else {
                stack.push(new myMap(i, s.charAt(i)));
            }
        }
        int num = 0;
        int max = 0;
        for (int i = 0; i < used.length; i++) {
            if (i > 0 && used[i] && used[i - 1]) {
                num++;
            } else {
                max = Math.max(max, num);
                num = 0;
            }
        }
        max = Math.max(max, num);
        return num == 0 && max == 0 ? 0 : max + 1;
    }
}
