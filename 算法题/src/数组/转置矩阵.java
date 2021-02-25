package 数组;

/**
 * @author 彭一鸣  https://leetcode-cn.com/problems/transpose-matrix/
 * @since 2021/2/25 14:24
 */
public class 转置矩阵 {
    public int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}
