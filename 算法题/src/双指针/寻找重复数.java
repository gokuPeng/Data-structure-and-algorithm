package 双指针;

/**
 * @author 彭一鸣
 * @since 2020/11/12 16:35
 */
// 287 寻找重复数 https://leetcode-cn.com/problems/find-the-duplicate-number/
public class 寻找重复数 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = 0;
                while(slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
}
