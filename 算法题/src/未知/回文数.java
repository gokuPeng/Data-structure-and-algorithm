package 未知;

/**
 * @author 彭一鸣  9. 回文数  https://leetcode-cn.com/problems/palindrome-number/
 * @since 2020/12/8 15:30
 */
public class 回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int i = 1;
        while(!((int)(x / Math.pow(10, i)) == 0)) {
            i++;
        }
        int sum = 0;
        int j = 0;
        for (j = 1; j <= i / 2; j++) {
            int num = (int) ((x % Math.pow(10, j)) / Math.pow(10, j - 1));
            sum += num * Math.pow(10, j - 1) + num * Math.pow(10, i - 1);
            i--;
        }
        if (x % 2 != 0) {
            sum += ((x % Math.pow(10, j + 1)) / Math.pow(10, j)) * Math.pow(10, i - 1);
        }
        System.out.println(sum);
        return true;
    }
}
