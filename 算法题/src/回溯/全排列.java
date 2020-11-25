package 回溯;

import com.sun.deploy.panel.RuleSetViewerDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭一鸣 46. 全排列 https://leetcode-cn.com/problems/permutations/comments/
 * @since 2020/11/18 13:43
 */
public class 全排列 {
//    List<List<Integer>> arrayLists = new ArrayList<>();
//    ArrayList<Integer> exitNum = new ArrayList<>();
//    int[] n;
//    public List<List<Integer>> permute(int[] nums) {
//        n = nums;
//        selectNum();
//        return arrayLists;
//    }
//
//    private void selectNum() {
//        if (exitNum.size() == n.length) {
//            ArrayList arrayList = new ArrayList<>(exitNum);
//            arrayLists.add(arrayList);
//            return;
//        }
//        for (int i = 0; i < n.length; i++) {
//            if (!exitNum.contains(n[i])) {
//                exitNum.add(n[i]);
//                selectNum();
//                exitNum.remove(exitNum.size() - 1);
//            }
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        DFS(result, list, nums, used);
        return result;
    }

    private void DFS(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                DFS(result, list, nums, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }

    }
}
