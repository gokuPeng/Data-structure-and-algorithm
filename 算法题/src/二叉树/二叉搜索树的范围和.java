package 二叉树;
// 938. 二叉搜索树的范围和 https://leetcode-cn.com/problems/range-sum-of-bst/submissions/
public class 二叉搜索树的范围和 {
    private int L;
    private int R;
    private int sum = 0;
    private boolean flag;
    public int rangeSumBST(TreeNode root, int L, int R) {
        this.L = L;
        this.R = R;
        inorder(root);
        return sum;
    }
    private void inorder(TreeNode root) {
        if (root == null || flag) return;
        inorder(root.left);
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        if (root.val > R) flag = true;
        inorder(root.right);
    }
}
