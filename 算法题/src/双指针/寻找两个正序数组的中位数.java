package 双指针;

import java.util.LinkedList;

/**
 * @author 彭一鸣
 * @since 2020/11/14 20:32
 */
// https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            list2.add(nums2[i]);
        }
        int min = 0;
        int max = 0;
        boolean flag = true; // true表示完结
        while(!(list1.isEmpty() && list2.isEmpty())) {
            if (flag) {
                if (!list1.isEmpty() && !list2.isEmpty()) {
                    if (list1.peekFirst() <= list2.peekFirst()) {
                        min = list1.pollFirst();
                    } else {
                        min = list2.pollFirst();
                    }
                } else if (list1.isEmpty()) {
                    min = list2.pollFirst();
                } else {
                    min = list1.pollFirst();
                }
            } else {
                if (!list1.isEmpty() && !list2.isEmpty()) {
                    if (list1.peekLast() >= list2.peekLast()) {
                        max = list1.pollLast();
                    } else {
                        max = list2.pollLast();
                    }
                } else if (list1.isEmpty()) {
                    max = list2.pollLast();
                } else {
                    max = list1.pollLast();
                }
            }
            flag = !flag;
        }
        return flag ? (min + max) / 2.0 : min;
    }
}
