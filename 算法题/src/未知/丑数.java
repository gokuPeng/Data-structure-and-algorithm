package 未知;

/**
 * @author 彭一鸣 263. 丑数 https://leetcode-cn.com/problems/ugly-number/
 * @since 2021/4/10 14:33
 */
public class 丑数 {
    public boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                break;
            }
        }
        return n == 1;
    }
}
