package 数组;

import java.util.*;

// 78. 子集 https://leetcode-cn.com/problems/subsets/
// 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
public class 子集 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2,3,6}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        List<List<Integer>> lists = subsets1(list);
        lists.add(new LinkedList<Integer>());
        return lists;
    }
    public static List<List<Integer>> subsets1(LinkedList<Integer> list) {
        if (list.size() - 1 == 0) {
            List<List<Integer>> linkedLists = new LinkedList<>();
            LinkedList<Integer> integers = new LinkedList<>();
            integers.add(list.get(0));
            linkedLists.add(integers);
            return linkedLists;
        }
        Integer last = list.removeLast();
        // 递归要干什么事
        List<List<Integer>> sublist = subsets1(new LinkedList<>(list));
        // 子集+子集里面每个都加上新增的数字+新增的数字
        List<List<Integer>> returnList = new LinkedList<>();
        for (List<Integer> integers : sublist) {
            // 子集 ------> sublist
            returnList.add(new LinkedList<>(integers));
            // 子集里面每个都加上新增的数字
            integers.add(last);
            returnList.add(integers);
        }

        // 新增的数字
        LinkedList<Integer> newInteger = new LinkedList<>();
        newInteger.add(last);
        returnList.add(newInteger);
        return returnList;
    }
}
