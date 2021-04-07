package 二分查找.长路漫漫;

/**
 * @author 彭一鸣
 * @since 2021/4/7 16:03
 */
public class 找出第一个大于小于目标元素的索引 {
    public static int highBoundnum(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int cmp = target - nums[mid];
            if (cmp >= 0) {
                right = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] >= target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int lowBoundnum(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int cmp = target - nums[mid];
            if (cmp <= 0) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] <= target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
