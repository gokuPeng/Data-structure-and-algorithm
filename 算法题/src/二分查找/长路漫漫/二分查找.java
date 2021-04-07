package 二分查找.长路漫漫;

/**
 * @author 彭一鸣  704. 二分查找   https://leetcode-cn.com/problems/binary-search/
 * @since 2021/4/7 15:42
 */
public class 二分查找 {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            int cmp = target - nums[mid];
            if (cmp > 0) {
                begin = mid + 1;
            } else if (cmp < 0) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return  -1;
    }
}
