package 数组;

/**
 * @author 彭一鸣  https://leetcode-cn.com/problems/flipping-an-image/
 * @since 2021/2/24 10:58
 */
public class 翻转图像 {
    public int[][] flipAndInvertImage(int[][] A) {
        int rowLength = A[0].length;
        int[][] ans = new int[A.length][rowLength];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < rowLength; j++) {
                ans[i][j] = A[i][rowLength - j - 1] ^ 1;
            }
        }
        return ans;
    }
}
