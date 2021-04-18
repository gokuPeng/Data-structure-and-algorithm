package 双指针;

/**
 * @author 彭一鸣
 * @since 2021/4/19 0:30
 */
public class 移除元素_双指针 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
