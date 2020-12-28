package 动态规划;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author 彭一鸣  53. 最大子序和   https://leetcode-cn.com/problems/maximum-subarray/
 * @since 2020/12/22 13:39
 */
public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int num : nums) {
            if (sum + num > 0) {
                sum += num;
                max = Math.max(max, sum);
            } else {
                sum = num > 0 ? num : 0;
                max = Math.max(max, num);
            }
        }
        return max;
    }
}
