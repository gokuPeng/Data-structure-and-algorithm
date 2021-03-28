package 二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 彭一鸣  173. 二叉搜索树迭代器   https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * @since 2021/3/28 8:43
 */
public class BSTIterator  {

    private Deque<Integer> TreeNodeList = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        TreeNodeList.addLast(root.val);
        dfs(root.right);
    }

    public int next() {
        return TreeNodeList.removeFirst();
    }

    public boolean hasNext() {
        return !TreeNodeList.isEmpty();
    }
}
