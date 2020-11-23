package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 彭一鸣  39. 组合总和  https://leetcode-cn.com/problems/combination-sum/
 * @since 2020/11/23 10:29
 */
public class 组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        Arrays.sort(candidates);
        selectNum(result, list, candidates, target, sum, 0);
        return result;
    }

    private void selectNum(List<List<Integer>> result, ArrayList<Integer> list, int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            List<Integer> copyList = new ArrayList<>(list);
            result.add(copyList);
            return;
        } else if (sum > target){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            if (sum > target) {
                list.remove(list.size() - 1);
                break;
            }
            selectNum(result, list, candidates, target, sum, i);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
