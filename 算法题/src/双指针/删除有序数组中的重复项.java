package 双指针;

/**
 * @author 彭一鸣  26. 删除有序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @since 2021/4/18 13:40
 */
public class 删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
