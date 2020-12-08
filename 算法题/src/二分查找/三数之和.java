package 二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 彭一鸣 15. 三数之和 https://leetcode-cn.com/problems/3sum/
 * @since 2020/12/8 9:22
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 第一个数nums[i]
            for (int j = i + 1; j < nums.length; j++) {
                // 第二个数nums[j]
                // 寻找第三个数
                if (j < nums.length - 1 && nums[j + 1] == nums[j]) continue;
                if (nums[j] == nums[j - 1] && nums[j] == nums[i] && nums[j] + nums[j - 1] + nums[i] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[j - 1]));
                    continue;
                }
                if (-nums[i] < nums[j]) return result;
                int target = 0 - nums[i] - nums[j];
                int x = binarySearch(nums, target, j + 1);
                if (x != -1) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[x]));
                }
            }
        }
        return result;
    }

    private int binarySearch(int[] nums, int target, int begin) {
        int end = nums.length;
        while (begin < end) {
            int mid = begin + (end - begin)/2;
            int cmp = target - nums[mid];
            if (cmp > 0) {
                begin = mid + 1;
            } else if (cmp < 0){
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
