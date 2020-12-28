package 动态规划;

/**
 * @author 彭一鸣  96. 不同的二叉搜索树    https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @since 2020/12/23 17:34
 */
public class 不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
