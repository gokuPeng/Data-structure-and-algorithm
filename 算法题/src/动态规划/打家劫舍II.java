package 动态规划;

/**
 * @author 彭一鸣 213. 打家劫舍 II https://leetcode-cn.com/problems/house-robber-ii/
 * @since 2021/4/15 10:34
 */
public class 打家劫舍II {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robByRange(0 , nums), robByRange(1, nums));
    }

    private int robByRange(int start, int[] nums) {
        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];
        dp1[0] = nums[start];
        dp2[0] = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            dp1[i] = dp2[i - 1] + nums[i + start];
            dp2[i] = Math.max(dp1[i - 1], dp2[i - 1]);
        }
        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}
