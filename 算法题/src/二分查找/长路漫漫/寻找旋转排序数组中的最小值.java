package 二分查找.长路漫漫;

/**
 * @author 彭一鸣 153. 寻找旋转排序数组中的最小值 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @since 2021/4/7 18:08
 */
public class 寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 判断是不是纯有序
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            // 判断落点
            if (nums[mid] >= nums[left]) {
                // 说明落在左边
                // 此时往右逼近、mid肯定不是最小值，所以可以排除
                left = mid + 1;
            } else {
                // 说明落在右边
                // 此时往左逼近、mid有可能是最小值，不能排除
                right = mid;
            }
        }
        return -1;
    }
}
