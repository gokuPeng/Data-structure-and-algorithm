package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭一鸣  54. 螺旋矩阵    https://leetcode-cn.com/problems/spiral-matrix/
 * @since 2021/3/15 23:15
 */
public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        // 46左右，28上下
        int flag = 6;
        int x = 0, y = 0;
        // 行的最大索引
        int rowLength = matrix.length - 1;
        // 列的最大索引
        int colLength = matrix[0].length - 1;
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        dg(flag, x, y, ans, rowLength, colLength, used, matrix);
        return ans;
    }

    private void dg(int flag, int x, int y, List<Integer> ans, int rowLength, int colLength, boolean[][] used, int[][] matrix) {
        ans.add(matrix[x][y]);
        used[x][y] = true;
        if (flag == 4 || flag == 6) {
            // 判断flag是哪个方向
            if (flag == 6) {
                // 说明下次应该往右边，或者上下，首先判断是不是右边
                if (y < colLength && !used[x][y + 1]) {
                    dg(flag, x, ++y, ans, rowLength, colLength, used, matrix);
                    return;
                }
            } else if (flag == 4) {
                // 说明下次应该往左边，或者上下，首先判断是不是左边
                if (y > 0 && !used[x][y - 1]) {
                    dg(flag, x, --y, ans, rowLength, colLength, used, matrix);
                    return;
                }
            }
            // 如果走到了这里，就是上下
            // 上
            if (x > 0 && !used[x - 1][y]) {
                dg(8, --x, y, ans, rowLength, colLength, used, matrix);
                return;
            }
            // 如果到了这里就是下
            if (x < rowLength && !used[x + 1][y]) {
                dg(2, ++x, y, ans, rowLength, colLength, used, matrix);
                return;
            }
        }
        if (flag == 2 || flag == 8) {
            // 判断flag是哪个方向
            if (flag == 2) {
                // 如果到了这里就是下
                if (x < rowLength && !used[x + 1][y]) {
                    dg(flag, ++x, y, ans, rowLength, colLength, used, matrix);
                    return;
                }
            } else if (flag == 8) {
                // 上
                if (x > 0 && !used[x - 1][y]) {
                    dg(flag, --x, y, ans, rowLength, colLength, used, matrix);
                    return;
                }
            }
            // 如果走到了这里，就是左右
            // 说明下次应该往左边，或者上下，首先判断是不是左边
            if (y > 0 && !used[x][y - 1]) {
                dg(4, x, --y, ans, rowLength, colLength, used, matrix);
                return;
            }
            // 如果到了这里就是右边
            if (y < colLength && !used[x][y + 1]) {
                dg(6, x, ++y, ans, rowLength, colLength, used, matrix);
                return;
            }
        }
    }
}
