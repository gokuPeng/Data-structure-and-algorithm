package 数组;

/**
 * @author 彭一鸣 73. 矩阵置零 https://leetcode-cn.com/problems/set-matrix-zeroes/
 * @since 2021/3/21 14:39
 */
public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagRow0 = false, flagCol0 = false;
        for (int i = 0; i < n; i++) {
            // 判断第一行有没有被修改
            if (matrix[0][i] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 0; i < m; i++) {
            // 判断第一列有没有被修改
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                // 将这一列置为0
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                // 将这一行置为0
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
