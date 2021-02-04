package 数组;

/**
 * @author 彭一鸣 643. 子数组最大平均数 I https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * @since 2021/2/4 9:53
 */
public class 子数组最大平均数I {
    public double findMaxAverage(int[] nums, int k) {
        // 先把nums[0]到nums[k - 1]的和记录下来
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = 1; i < nums.length && i + k - 1 < nums.length; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            max = Math.max(sum, max);
        }
        return (double)max / k;
    }
}
