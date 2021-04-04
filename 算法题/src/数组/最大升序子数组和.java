package 数组;

/**
 * @author 彭一鸣 1800. 最大升序子数组和 https://leetcode-cn.com/problems/maximum-ascending-subarray-sum/
 * @since 2021/4/4 16:08
 */
public class 最大升序子数组和 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                max = Math.max(max, sum);
                sum = nums[i];
            }
        }
        return Math.max(max, sum);
    }
}
