package 数组;

/**
 * @author 彭一鸣 304.二维区域和检索_矩阵不可变_暴力 https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * @since 2021/3/2 10:23
 */
public class NumMatrix {

    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        // 坐标必须满足如下条件
        // 1、横坐标 row1 <= x <= row2
        // 2、纵坐标 col1 <= y <= col2
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                ans += matrix[i][j];
            }
        }
        return ans;
    }

}
