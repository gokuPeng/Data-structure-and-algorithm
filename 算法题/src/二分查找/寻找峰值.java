package 二分查找;

/**
 * @author 彭一鸣  https://leetcode-cn.com/problems/find-peak-element/
 * @since 2020/11/15 10:42
 */
public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            if (begin == end - 1) {
                return nums[begin] > nums[end] ? begin : end;
            } else {
                int mid = (begin + end) >> 1;   //1
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid + 1] > nums[mid]){
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return nums[begin] > nums[end] ? begin : end;
    }
}
