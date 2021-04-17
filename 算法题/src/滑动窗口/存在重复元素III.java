package 滑动窗口;

import java.util.TreeSet;

/**
 * @author 彭一鸣 220. 存在重复元素 III https://leetcode-cn.com/problems/contains-duplicate-iii/
 * @since 2021/4/17 0:15
 */
public class 存在重复元素III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            Long u = nums[i] * 1L;
            Long l = treeSet.floor(u);
            Long r = treeSet.ceiling(u);
            if(l != null && u - l <= t) {
                return true;
            }
            if(r != null && r - u <= t) {
                return true;
            }
            treeSet.add(u);
            if (i >= k) {
                treeSet.remove(nums[i - k] * 1L);
            }
        }
        return false;
    }
}
