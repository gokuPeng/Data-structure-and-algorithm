package 数组;

/**
 * @author 彭一鸣 136. 只出现一次的数字 https://leetcode-cn.com/problems/single-number/
 * @since 2021/1/29 17:33
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
