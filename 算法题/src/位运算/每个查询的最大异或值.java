package 位运算;

/**
 * @author 彭一鸣  1829. 每个查询的最大异或值    https://leetcode-cn.com/problems/maximum-xor-for-each-query/
 * @since 2021/4/21 17:36
 */
public class 每个查询的最大异或值 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int[n];
        int max = (int) (Math.pow(2, maximumBit) - 1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= nums[i];
            ans[n - i - 1] = result ^ max;
        }
        return ans;
    }
}
