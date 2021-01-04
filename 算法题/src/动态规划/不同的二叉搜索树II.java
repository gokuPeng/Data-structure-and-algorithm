package 动态规划;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭一鸣 95. 不同的二叉搜索树 II https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * @since 2020/12/24 10:57
 */
public class 不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode());
            return list;
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    list.add(treeNode);
                }
            }
        }
        return list;
    }
}
