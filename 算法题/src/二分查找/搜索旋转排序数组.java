package 二分查找;

/**
 * @author 彭一鸣 33. 搜索旋转排序数组 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @since 2020/12/15 15:22
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        while(begin < end) {
            int mid = begin + (end - begin) / 2;
            int cmp = target - nums[mid];
            if (cmp > 0) {
                // 假设mid的右边是转折点，显然是右边的
                if (nums[begin] < nums[mid]) {
                    begin = mid + 1;
                } else {
                    // 假设mid的左边是转折点，则比较end和target来判断要那一边
                    if (target > nums[end - 1]) {
                        end = mid;
                    } else if (target < nums[end - 1]) {
                        begin = mid + 1;
                    } else {
                        return end - 1;
                    }
                }
            } else if (cmp < 0) {
                // 假设mid的左边是转折点，显然是左边的
                if (nums[begin] > nums[mid]) {
                    end = mid;
                } else {
                    // 假设mid的右边是转折点，则比较begin和target来判断要那一边
                    if (target < nums[begin]) {
                        begin = mid + 1;
                    } else if (target > nums[begin]) {
                        end = mid;
                    } else {
                        return begin;
                    }
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}
