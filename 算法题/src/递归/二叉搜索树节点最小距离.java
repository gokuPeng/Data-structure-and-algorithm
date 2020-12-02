package 递归;

import 二叉树.TreeNode;

/**
 * @author 彭一鸣 783. 二叉搜索树节点最小距离 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * @since 2020/12/2 14:17
 */
public class 二叉搜索树节点最小距离 {
    int min = Integer.MAX_VALUE;
    int cur = -1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (cur == -1) {
            cur = root.val;
        } else {
            if ((root.val - cur) < min) {
                min = root.val - cur;
            };
            cur = root.val;
        }
        dfs(root.right);
    }
}
