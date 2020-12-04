package 未知;

/**
 * @author 彭一鸣 66. 加一 https://leetcode-cn.com/problems/plus-one/submissions/
 * @since 2020/12/4 9:39
 */
public class 加一 {
    public int[] plusOne(int[] digits) {
        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int a = digits[i] + temp;
            digits[i] = a % 10;
            temp = a / 10;
        }
        if (temp > 0) {
            int[] digitss = new int[digits.length + 1];
            digitss[0] = temp;
            System.arraycopy(digits, 0, digitss, 1, digits.length);
            return digitss;
        }
        return digits;
    }
}
