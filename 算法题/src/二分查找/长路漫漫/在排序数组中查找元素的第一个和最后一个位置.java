package 二分查找.长路漫漫;

/**
 * @author 彭一鸣 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @since 2021/4/7 15:46
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int left = findFirstIndex(nums, target, 0, nums.length - 1);
        int right = findLastIndex(nums, target, 0, nums.length - 1);
        if (left > right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }


    private int findFirstIndex(int[] nums, int target, int begin, int end) {
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            int cmp = target - nums[mid];
            if (cmp > 0) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return begin;
    }

    private int findLastIndex(int[] nums, int target, int begin, int end) {
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            int cmp = target - nums[mid];
            if (cmp >= 0) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

}
