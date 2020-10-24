package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历 {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        TreeNode cur = root;
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return list;
    }
}
