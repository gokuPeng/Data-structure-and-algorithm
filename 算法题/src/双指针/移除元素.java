package 双指针;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author 彭一鸣
 * @since 2020/11/10 19:03
 */
// 27. 移除元素 https://leetcode-cn.com/problems/remove-element/
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++,j++) {
            if(j == nums.length) break;
            if (nums[i] == val) {
                System.arraycopy(nums, i + 1, nums, i, nums.length - i - 1);
                i--;
            } else {
                length++;
            }
        }
        return length;
    }
}
