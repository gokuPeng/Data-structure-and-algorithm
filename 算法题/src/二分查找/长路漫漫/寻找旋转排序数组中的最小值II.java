package 二分查找.长路漫漫;

/**
 * @author 彭一鸣 154. 寻找旋转排序数组中的最小值 II https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @since 2021/4/8 0:01
 */
public class 寻找旋转排序数组中的最小值II {
    public int findMin(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            // 首先判断这个区间是不是升序的
            if (nums[end] > nums[begin]) {
                // 升序
                return nums[begin];
            }
            if (nums[end] == nums[begin]) {
                // 如果只有<2位数，那就是升序
                if (end - begin < 2) {
                    return nums[begin];
                } else {
                    // 这个时候根本判断不出来，begin往前一位
                    begin++;
                    continue;
                }
            }
            // 走到了这里说明不是升序的
            // 判断落点
            if (nums[mid] >= nums[begin]) {
                // 如果中间的数>=开始的，则证明落点在左边的数组
                // 如果在左边，那么直接排除这个点，往右边逼近
                begin = mid + 1;
            } else {
                // 如果中间的数<开始的，则证明落点在右边的数组
                // 如果在右边，这个点可能是最小值，不能排除
                end = mid;
            }
        }
        return -1;
    }
}
