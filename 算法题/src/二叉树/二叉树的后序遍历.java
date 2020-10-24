package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的后序遍历 {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return list;
        stack1.push(root);
        while (!stack1.empty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.empty()) {
            list.add(stack2.pop().val);
        }
        return list;
    }
}
