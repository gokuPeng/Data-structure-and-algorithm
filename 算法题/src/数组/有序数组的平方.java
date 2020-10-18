package 数组;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
// 977. 有序数组的平方 https://leetcode-cn.com/problems/squares-of-a-sorted-array/
public class 有序数组的平方 {
    public static void main(String[] args) {
        SolutionA solutionA = new SolutionA();
        int[] ints = solutionA.sortedSquares(new int[]{-2,-1,3});
        System.out.println(Arrays.toString(ints));
    }
}
class SolutionA {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int curOne = 0;
        int curTwo = A.length - 1;
        int i = A.length - 1;
        while (curOne <= curTwo) {
            if (A[curOne]*A[curOne] < A[curTwo]*A[curTwo]) {
                result[i--] = A[curTwo]*A[curTwo--];
            } else {
                result[i--] = A[curOne]*A[curOne++];
            }
        }
        return result;
    }
}
