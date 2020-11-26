package 回溯;

import java.util.*;

/**
 * @author 彭一鸣 77. 组合 https://leetcode-cn.com/problems/combinations/submissions/
 * @since 2020/11/26 14:38
 */
public class 组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        dfs(result, stack, n, k, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayDeque<Integer> stack,int n, int k, int index) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index; i < n; i++) {
            stack.add(i + 1);
            dfs(result, stack, n, k, i + 1);
            stack.removeLast();
        }
    }
}
