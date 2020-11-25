package 回溯;

import java.util.*;

/**
 * @author 彭一鸣  47. 全排列 II  https://leetcode-cn.com/problems/permutations-ii/
 * @since 2020/11/25 11:20
 */
public class 全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        DFS(result, list, nums, used);
        return result;
    }

    private void DFS(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            DFS(result, list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
