package 未知;

/**
 * @author 彭一鸣  1828. 统计一个圆中点的数目    https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle/
 * @since 2021/4/21 14:03
 */
public class 统计一个圆中点的数目 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < points.length; j++) {
                // 判断这个点在不在圆内、主要是判断和圆心的距离
                int lengthPow = (queries[i][0] - points[j][0]) * (queries[i][0] - points[j][0])
                        + (queries[i][1] - points[j][1]) * (queries[i][1] - points[j][1]);
                int rPow = queries[i][2] * queries[i][2];
                if (lengthPow <= rPow) {
                    ans[i] += 1;
                }
            }
        }
        return ans;
    }
}
