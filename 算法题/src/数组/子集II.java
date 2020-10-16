package 数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 子集II {
    public static void main(String[] args) {
        List<List<Integer>> list = new Solution().subsetsWithDup(new int[]{2, 1, 2, 1, 3});
        System.out.println(list);
    }
}
class Solution {
    private List<List<Integer>> bigList = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 一开始选择子集为空的，慢慢加1
        for (int i = 0; i <= nums.length; i++) {
            bigList = selectSets(i, nums);
        }
        return bigList;
    }

    public List<List<Integer>> selectSets(int n, int[] nums) {
        if (n == 0) {
            List<List<Integer>> biglist0 = new ArrayList<List<Integer>>();
            ArrayList<Integer> list0 = new ArrayList<>();
            biglist0.add(list0);
            return biglist0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        // bigList复制出一份，然后往复制的里面插入新增的数
        List<List<Integer>> copyList = new LinkedList<>();
        for (List<Integer> integers : bigList) {
            ArrayList<Integer> src = new ArrayList<Integer>(integers);
            copyList.add(src);
        }
        for (List<Integer> integers : copyList) {
            // 改变插入顺序
            // integers.add(nums[n - 1]);
            // 判断nums[n - 1]应该插入在哪个位置
            int end = integers.size();
            int begin = 0;
            while (begin < end) {
                int mid = (begin + end) >> 1;
                if (nums[n - 1] < integers.get(mid)) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            }
            integers.add(begin, nums[n - 1]);

            if(!bigList.contains(integers)) {
                bigList.add(integers);
            }
        }
        return bigList;
    }
}
