package 未知;

/**
 * @author 彭一鸣 264. 丑数 II https://leetcode-cn.com/problems/ugly-number-ii/
 * @since 2021/4/11 0:02
 */
public class 丑数II {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] uglyNumebr = new int[n];
        uglyNumebr[0] = 1;
        for (int i = 1; i < n; i++) {
            int temp2 = uglyNumebr[p2] * 2;
            int temp3 = uglyNumebr[p3] * 3;
            int temp5 = uglyNumebr[p5] * 5;
            if (temp2  <= temp3 && temp2 <= temp5) {
                uglyNumebr[i] = temp2;
                p2++;
            }
            if (temp3  <= temp2 && temp3 <= temp5) {
                uglyNumebr[i] = temp3;
                p3++;
            }
            if (temp5  <= temp2 && temp5 <= temp3) {
                uglyNumebr[i] = temp5;
                p5++;
            }
        }
        return uglyNumebr[n - 1];
    }
}
