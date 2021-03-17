package 递归;

/**
 * @author 彭一鸣
 * @since 2021/3/16 9:28
 */
public class 螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        dg(0, 0, 1, ans, n);
        return ans;
    }
    private void dg(int beginX, int beginY, int num, int[][] ans, int n) {
        if (n == 0) {
            return;
        }
        // 向右
        int i = beginY;
        for (; i < n; i++) {
            ans[beginX][i] = num++;
        }
        // 向下
        int j = beginX + 1;
        for (; j < n; j++) {
            ans[j][i - 1] = num++;
        }
        // 向左
        int l = i - 2;
        for (; l >= beginY; l--) {
            ans[j - 1][l] = num++;
        }
        // 向上
        int k = j - 2;
        for (; k > beginX; k--) {
            ans[k][l + 1] = num++;
        }
        dg(beginX + 1, beginY + 1, num, ans, n - 1);
    }
}
