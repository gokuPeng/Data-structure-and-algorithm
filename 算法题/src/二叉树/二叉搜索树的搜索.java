package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

// 700. 二叉搜索树中的搜索 https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
public class 二叉搜索树的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (val == node.val) return node;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return null;
    }
}
