package 回溯;

import java.util.*;

/**
 * @author 彭一鸣  22. 括号生成  https://leetcode-cn.com/problems/generate-parentheses/
 * @since 2020/11/21 11:49
 */
public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        insert(sb, result, n, 0);
        return new ArrayList<>(result);
    }

    /**
     * 插入括号
     * @param sb  即将放入result中的结果
     * @param result    最后的结果
     * @param n 一共有多少括号
     * @param i 这是第几对括号
     */
    private void insert(StringBuilder sb, Set<String> result, int n, int i) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }
        int length = sb.length();
        for (int j = 0; j <= length; j++) {
            char[] c = {'(', ')'};
            sb.insert(j, c);
            insert(sb, result, n , j + 1);
            sb.delete(j, j + 2);
        }
    }
}
