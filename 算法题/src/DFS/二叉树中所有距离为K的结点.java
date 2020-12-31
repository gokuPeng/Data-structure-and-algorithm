package DFS;

import 二叉树.TreeNode;

import java.util.*;

/**
 * @author 彭一鸣 863. 二叉树中所有距离为 K 的结点 https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 * @since 2020/12/28 19:07
 */
public class 二叉树中所有距离为K的结点 {

    private Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> list = new ArrayList<>();
            order(root, target, K, list);
            int lr = 0; // 1表示从左边上来的，2表示从右边上来的
            // i表示父节点的数量
            for (int i = 1; i <= K; i++) {
                TreeNode parent = target;
                for (int j = 0; j < i; j++) {
                    if (j == i - 1) {
                        if (map.get(parent) != null) {
                            lr = map.get(parent).left == parent ? 1 : 2;
                        }
                    }
                    parent = map.get(parent);
                }
                // 如果父节点的数量为i，那么从顶上的父节点到其他子树的距离为K-i
                if (i == K) {
                    // 如果不需要往下找了
                    // 直接添加父节点
                    if (parent != null) {
                        list.add(parent.val);
                    }
                } else if (i == K - 1){
                    if (parent != null) {
                        // 如果需要往下找，但是只要一个
                        if (lr == 1 && parent.right != null) {
                            // 从左边上来的，那就是父节点的右边
                            list.add(parent.right.val);
                        }
                        if (lr == 2 && parent.left != null) {
                            // 从右边上来的，那就是父节点的左边
                            list.add(parent.left.val);
                        }
                    }
                } else {
                    if (parent != null) {
                        TreeNode node = new TreeNode();
                        if (lr == 1 && parent.right != null) {
                            // 从左边上来的，那就是父节点的右边
                            node = parent.right;
                        }
                        if (lr == 2 && parent.left != null) {
                            // 从右边上来的，那就是父节点的左边
                            node = parent.left;
                        }
                        place(node, K - i - 1, list);
                    }
                }
            }
        return list;
    }

    // 把结点下的第K层选出来
    private void place(TreeNode target, int k, List list) {
        int size = 1;
        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);
        while(!queue.isEmpty()) {
            size--;
            TreeNode poll = queue.poll();
            if (level == k) {
                list.add(poll.val);
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (size == 0) {
                level++;
                size = queue.size();
            }
        }
    }

    private void order(TreeNode root, TreeNode target, int k, List list) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == target) {
                place(target, k, list);
            }
            if (poll.left != null) {
                map.put(poll.left, poll);
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                map.put(poll.right, poll);
                queue.offer(poll.right);
            }
        }
    }
}
