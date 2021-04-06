package 数组;

/**
 * @author 彭一鸣 80. 删除有序数组中的重复项 II https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @since 2021/4/6 15:30
 */
public class 删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int length = nums.length;
        for (int i = 2; i < length; i++) {
            if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                System.arraycopy(nums, i, nums, i - 1, nums.length - i);
                i--;
                length--;
            }
        }
        return length;
    }
}
