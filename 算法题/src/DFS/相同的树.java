package DFS;

import 二叉树.TreeNode;

/**
 * @author 彭一鸣 100. 相同的树100. 相同的树 https://leetcode-cn.com/problems/same-tree/
 * @since 2020/11/29 12:57
 */
public class 相同的树 {
    private boolean result = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);
        return result;
    }

    private void dfs(TreeNode p, TreeNode q) {
        if (result == false) return;
        if (p == null) {
            if (q == null) {
                return;
            } else {
                result = false;
            }
        } else {
            if (q == null) {
                result = false;
            } else {
                if (p.val == q.val) {
                    dfs(p.left, q.left);
                    dfs(p.right, q.right);
                } else {
                    result = false;
                }
            }
        }
    }
}
