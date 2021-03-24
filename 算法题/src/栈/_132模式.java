package 栈;

/**
 * @author 彭一鸣 456. 132模式 https://leetcode-cn.com/problems/132-pattern/submissions/
 * @since 2021/3/24 10:41
 */
public class _132模式 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int min = nums[i];
            // 找右边的数
            int max = min;
            int mid;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                } else {
                    mid = nums[j];
                    if (min < mid && mid < max) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
