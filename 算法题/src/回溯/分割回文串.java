package 回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author 彭一鸣 131. 分割回文串 https://leetcode-cn.com/problems/palindrome-partitioning/
 * @since 2021/1/19 16:21
 */
public class 分割回文串 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<String>();
        dfs(0, s, stack, ans);
        return ans;
    }

    private void dfs(int index, String s, Deque<String> stack, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            StringBuilder sb = new StringBuilder(sub);
            StringBuilder reverse = sb.reverse();
            if (sub.equals(reverse.toString())) {
                stack.addLast(sub);
                dfs(i + 1, s, stack, ans);
                stack.removeLast();
            } else {
                continue;
            }
        }
    }
}
