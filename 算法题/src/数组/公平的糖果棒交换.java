package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 彭一鸣 888. 公平的糖果棒交换 https://leetcode-cn.com/problems/fair-candy-swap/
 * @since 2021/2/1 9:13
 */
public class 公平的糖果棒交换 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int sub = (sumB - sumA) / 2;
        // map用于存储（sub + A，A）
        // 当遍历B的时候，map中key为B的值，value为应该要的A
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i] + sub, A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            if (map.get(B[i]) != null) {
                ans[0] = map.get(B[i]);
                ans[1] = B[i];
                break;
            }
        }
        return ans;
    }
}
