package DFS;

import 二叉树.TreeNode;

/**
 * @author 彭一鸣 101. 对称二叉树 https://leetcode-cn.com/problems/symmetric-tree/
 * @since 2020/11/29 20:52
 */
public class 对称二叉树 {
    boolean result = true;
    public boolean isSymmetric(TreeNode root) {
        if (root != null) dfs(root.left, root.right);
        return result;
    }

    private void dfs(TreeNode a, TreeNode b) {
        if (!result) return;
        if (a != null && b != null) {
            if (a.val != b.val) {
                result = false;
            } else {
                if (a.val != b.val) result = false;
                dfs(a.left, b.right);
                dfs(a.right, b.left);
            }
        } else if (a == null && b == null) {
            return;
        } else {
            result = false;
        }
    }
}
