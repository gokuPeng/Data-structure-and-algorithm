package 二分查找.长路漫漫;

/**
 * @author 彭一鸣 74. 搜索二维矩阵 https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @since 2021/4/7 19:59
 */
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int begin = 0, end = rowLength * colLength - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            // 计算mid的坐标
            int x = mid / colLength;
            int y = mid % colLength;
            int cmp = target - matrix[x][y];
            if (cmp > 0) {
                begin = mid + 1;
            } else if (cmp < 0) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
