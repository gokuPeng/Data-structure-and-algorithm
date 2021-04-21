package 数组;

/**
 * @author 彭一鸣 1827. 最少操作使数组递增 https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-increasing/
 * @since 2021/4/21 13:52
 */
public class 最少操作使数组递增 {
    public int minOperations(int[] nums) {
        int ans = 0;
        if (nums.length < 2) {
            return 0;
        }
        int lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= lastNum) {
                ans += lastNum + 1 - nums[i];
                lastNum = nums[i - 1] + 1;
            } else {
                lastNum = nums[i];
            }
        }
        return ans;
    }
}
