package 数组;

/**
 * @author 彭一鸣 26. 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @since 2021/1/26 18:03
 */
public class 删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                System.arraycopy(nums, i, nums, i - 1, nums.length - i);
                --i;
                length--;
            }
        }
        return length;
    }
}
