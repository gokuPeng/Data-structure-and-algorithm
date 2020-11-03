package 队列;

// 993. 二叉树的堂兄弟节点 https://leetcode-cn.com/problems/cousins-in-binary-tree/

import 二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的堂兄弟节点 {
    public boolean isCousins(TreeNode root, int x, int y) {
        // 判断是否在同一层，用层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        TreeNode parent = root;
        queue.offer(node);
        int level = 0;
        int xlevlel = -1;
        int ylevlel = -1;
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            size--;
            if (poll.left != null) {
                if (x == poll.left.val) {
                    xlevlel = level;
                    System.out.println("xlevlel:" + xlevlel);
                    parent = poll;
                }
                if (y == poll.left.val) {
                    ylevlel = level;
                    System.out.println("ylevlel:" + ylevlel);
                    parent = poll;
                }
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                if (x == poll.right.val) {
                    xlevlel = level;
                    System.out.println("xlevlel:" + xlevlel);
                    parent = poll;
                }
                if (y == poll.right.val) {
                    ylevlel = level;
                    System.out.println("ylevlel:" + ylevlel);
                    parent = poll;
                }
                queue.offer(poll.right);
            }
            if (size == 0) {
                size = queue.size();
                level++;
            }
        }
        if (xlevlel != ylevlel) return false;
        if (parent.left != null && parent.right != null) {
            if (parent.left.val == x && parent.right.val == y) return false;
            if (parent.left.val == y && parent.right.val == x) return false;
        }
        return true;
    }
}
