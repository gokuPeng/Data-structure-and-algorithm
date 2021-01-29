package 二叉树;

/**
 * @author 彭一鸣 617. 合并二叉树  https://leetcode-cn.com/problems/merge-two-binary-trees/submissions/
 * @since 2021/1/29 16:33
 */
public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode t3 = new TreeNode();
        dfs(t1, t2, t3);
        return t1 == null && t2 == null ? null : t3;
    }

    private void dfs(TreeNode t1, TreeNode t2, TreeNode t3) {
        if (t1 == null && t2 == null) {
            return;
        }
        TreeNode leftNode = new TreeNode();
        TreeNode rightNode = new TreeNode();
        if (t1 != null && t2 != null) {
            t3.val = t1.val + t2.val;
            if (t1.left != null || t2.left != null) {
                t3.left = leftNode;
                dfs(t1.left, t2.left, leftNode);
            }
            if (t1.right != null || t2.right != null) {
                t3.right = rightNode;
                dfs(t1.right, t2.right, rightNode);
            }
        } else if (t1 != null && t2 == null){
            if (t1.left != null) {
                t3.left = leftNode;
                dfs(t1.left, null, leftNode);
            }
            if (t1.right != null) {
                t3.right = rightNode;
                dfs(t1.right, null, rightNode);
            }
            t3.val = t1.val;
        } else {
            t3.val = t2.val;
            if (t2.left != null) {
                t3.left = leftNode;
                dfs(null, t2.left, leftNode);
            }
            if (t2.right != null) {
                t3.right = rightNode;
                dfs(null, t2.right, rightNode);
            }
        }
    }
}
