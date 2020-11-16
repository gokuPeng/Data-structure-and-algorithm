package 二分查找;

import java.util.Arrays;

/**
 * @author 彭一鸣  74. 搜索二维矩阵  https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @since 2020/11/16 10:30
 */
public class 搜索二维矩阵 {
    private int row;
    private int col;
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length > 0) {
            row = matrix.length - 1;
            if (matrix[0].length > 0) {
                col = matrix[0].length - 1;
            }
        } else {
            return false;
        }
        int begin = 0;
        int end = toIndex(row, col);
        while (begin <= end) {
            int mid = (begin + end) >> 1;
            int[] ints = indexTo(mid);
            System.out.println(Arrays.toString(ints));
            int cmp = target - matrix[ints[0]][ints[1]];
            if (cmp > 0) {
                begin = mid + 1;
                System.out.println(begin);
            } else if (cmp < 0){
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
    // 二维数组坐标转索引
    private int toIndex(int rowIndex, int colIndex) {
        int index = rowIndex * (col + 1) + colIndex;
        return index;
    }
    // 索引转坐标
    private int[] indexTo(int index) {
        int rowIndex = index / (col + 1);
        int colIndex = index - (rowIndex) * (col + 1);
        return new int[] {rowIndex, colIndex};
    }

}
