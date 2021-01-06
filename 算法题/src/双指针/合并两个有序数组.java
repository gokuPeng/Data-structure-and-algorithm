package 双指针;

import java.util.Arrays;

/**
 * @author 彭一鸣 88. 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 * @since 2021/1/4 17:36
 */
public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = 0;
        int q = 0;
        int[] nums3 = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            if (q == n) {
                nums3[i] = nums1[p++];
                continue;
            }
            if (p == m) {
                nums3[i] = nums2[q++];
                continue;
            }
            if (nums1[p] <= nums2[q]) {
                nums3[i] = nums1[p++];
            } else {
                nums3[i] = nums2[q++];
            }
        }
        System.arraycopy(nums3, 0, nums1, 0, m + n);
    }
}
