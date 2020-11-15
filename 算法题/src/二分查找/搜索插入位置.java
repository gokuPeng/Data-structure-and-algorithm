package 二分查找;

/**
 * @author 彭一鸣  https://leetcode-cn.com/problems/search-insert-position/
 * @since 2020/11/15 10:22      [1,3,5,6], 5
 */
public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;   // 0+4/2=2
            int cmp = target - nums[mid];
            if (cmp > 0) {
                begin = mid + 1;
            } else {
                end = mid;  // end = 2;
            }
        }
        return begin;
    }
}
