package 数组;

import java.util.Arrays;

/**
 * @author 彭一鸣  48. 旋转图像  https://leetcode-cn.com/problems/rotate-image/
 * @since 2020/12/15 19:26
 */
public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length - i - 1; j++) {
                // 右旋
                int temp = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = matrix[i][j];
                // 下旋
                int temp2 = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = temp;
                // 左旋
                int temp3 = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = temp2;
                // 上旋
                matrix[i][j] = temp3;
            }
        }
    }
}
