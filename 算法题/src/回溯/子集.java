package 回溯;

import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.select;

/**
 * @author 彭一鸣  78. 子集   https://leetcode-cn.com/problems/subsets/
 * @since 2020/11/18 15:54
 */
public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            // 选几个数
            select(i,0 ,nums, list, i, result);
            list.clear();
        }
        return result;
    }

    private void select(int i,int start, int[] nums, ArrayList<Integer> list, int num, List<List<Integer>> result) {
        if (list.size() == num) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 只能从start开始，要不然不是子集
        for (int j = start; j < nums.length; j++) {
            list.add(nums[j]);
            select(i - 1, j + 1, nums, list, num, result);
            list.remove(list.size() - 1);
        }
    }
}
