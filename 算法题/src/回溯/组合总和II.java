package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 彭一鸣
 * @since 2020/11/23 13:42
 */
public class 组合总和II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i > index && candidates[i] == candidates[i-1])
                continue;
            sum += candidates[i];
            if (sum > target) {
                break;
            }
            list.add(candidates[i]);
            selectNum(result, list, candidates, target, sum, i + 1);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
