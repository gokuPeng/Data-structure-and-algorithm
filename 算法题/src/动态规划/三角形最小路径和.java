package 动态规划;

import java.util.Arrays;
import java.util.List;

/**
 * @author 彭一鸣  120. 三角形最小路径和   https://leetcode-cn.com/problems/triangle/
 * @since 2021/1/19 15:20
 */
public class 三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    // 只可能来自上面
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1){
                    // 只可能来自上面的左边
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1])  + triangle.get(i).get(j);
                }
            }
        }
        return Arrays.stream(dp[triangle.size() - 1]).min().getAsInt();
    }
}
