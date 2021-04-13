package 二叉树;

/**
 * @author 彭一鸣 783. 二叉搜索树节点最小距离 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * @since 2021/4/13 11:32
 */
public class 二叉搜索树节点最小距离 {
    public int minDiffInBST(TreeNode root) {
        int[] flag = new int[2];
        flag[0] = Integer.MAX_VALUE;
        flag[1] = -1;
        dfs(root, flag);
        return flag[0];
    }

    private void dfs(TreeNode root, int[] flag) {
        if (root == null) {
            return;
        }
        dfs(root.left, flag);
        if (flag[1] != -1) {
            flag[0] = Math.min(root.val - flag[1], flag[0]);
        }
        flag[1] = root.val;
        dfs(root.right, flag);
    }
}
