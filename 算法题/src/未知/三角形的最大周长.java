package 未知;

import java.util.Arrays;

/**
 * @author 彭一鸣 976. 三角形的最大周长  https://leetcode-cn.com/problems/largest-perimeter-triangle/submissions/
 * @since 2020/11/29 13:43
 */
public class 三角形的最大周长 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int flag = 1;
        int a = A[A.length - 1], b = A[A.length - 2], c = A[A.length - 3];
        if (isTriangle(a, b, c)) {
            return a + b + c;
        }
        for (int i = A.length - 4; i >= 0; i--) {
            switch (flag) {
                case 1:
                    a = A[i];
                    flag = 2;
                case 2:
                    b = A[i];
                    flag = 3;
                case 3:
                    c = A[i];
                    flag = 1;
            }
            if (isTriangle(a, b, c)) {
                return a + b + c;
            }
        }
        return 0;
    }

    private boolean isTriangle(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a &&
                Math.abs(a - b) < c && Math.abs(a - c) < b && Math.abs(b - c) < a
        ) return true;
        return false;
    }
}
