package 二分查找;

/**
 * @author 彭一鸣 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @since 2020/12/1 17:26
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        int indexStart = binarySearchStart(nums, target);
        if (indexStart > nums.length - 1 || nums[indexStart] != target) return new int[] {-1, -1};
        int indexEnd = binarySearchEnd(nums, target);
        return new int[] {indexStart, indexEnd - 1};
    }

    private int binarySearchStart(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            int cmp = target - nums[mid];
            if (cmp > 0) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }

    private int binarySearchEnd(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            int cmp = target - nums[mid];
            if (cmp >= 0) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }
}
