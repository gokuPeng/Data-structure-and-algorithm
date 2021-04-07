package 二分查找.长路漫漫;

/**
 * @author 彭一鸣 33. 搜索旋转排序数组II https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @since 2021/4/7 16:50
 */
public class 搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            int cmp = target - nums[mid];
            // 怎么分辨mid在左边还是右边的数组
            // 表示mid落在了左边的数组
            if (cmp == 0) {
                return true;
            }
            if (nums[mid] > nums[begin]) {
                // 如果target > mid，那好办，begin向右边逼近
                if (cmp > 0) {
                    begin = mid + 1;
                } else if (cmp < 0) {
                    // 如果target < mid
                    // 此时有三种可能性
                    // 1、nums[begin] > target的话，向右逼近 2、nums[begin] < target，向左逼近 3、返回begin
                    if (nums[begin] > target) {
                        begin = mid + 1;
                    } else if (nums[begin] < target) {
                        end = mid - 1;
                    } else {
                        return true;
                    }
                }
            } else if (nums[mid] < nums[begin]) {
                // 表示mid落在了右边的数组
                // 如果target < mid，那好办，向左逼近
                if (cmp < 0) {
                    end = mid - 1;
                } else if (cmp > 0) {
                    // 如果target > mid
                    // 这个时候有三种情况
                    // 1、target > nums[end]，向左逼近 2、target < nums[end]，向右逼近 3、返回end
                    if (target > nums[end]) {
                        end = mid - 1;
                    } else if (target < nums[end]) {
                        begin = mid + 1;
                    } else {
                        return true;
                    }
                }
            } else {
                begin++;
            }
        }
        return false;
    }
}
