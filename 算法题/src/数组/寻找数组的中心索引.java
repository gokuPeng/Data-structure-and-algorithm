package 数组;

import java.util.Arrays;

/**
 * @author 彭一鸣 724. 寻找数组的中心索引 https://leetcode-cn.com/problems/find-pivot-index/
 * @since 2021/1/28 19:26
 */
public class 寻找数组的中心索引 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum == (total - nums[i])) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
