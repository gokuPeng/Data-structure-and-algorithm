package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭一鸣 46. 全排列 https://leetcode-cn.com/problems/permutations/comments/
 * @since 2020/11/18 13:43
 */
public class 全排列 {
    List<List<Integer>> arrayLists = new ArrayList<>();;
    ArrayList<Integer> exitNum = new ArrayList<>();
    int[] n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums;
        selectNum();
        return arrayLists;
    }

    private void selectNum() {
        if (exitNum.size() == n.length) {
            ArrayList arrayList = new ArrayList<>(exitNum);
            arrayLists.add(arrayList);
            return;
        }
        for (int i = 0; i < n.length; i++) {
            if (!exitNum.contains(n[i])) {
                exitNum.add(n[i]);
                selectNum();
                exitNum.remove(exitNum.size() - 1);
            }
        }
    }
}
