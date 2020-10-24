package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉搜索树的前序遍历 {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return list;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
