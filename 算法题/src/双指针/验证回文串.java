package 双指针;

/**
 * @author 彭一鸣
 * @since 2020/11/11 16:11
 */
// 125. 验证回文串 https://leetcode-cn.com/problems/valid-palindrome/
public class 验证回文串 {
    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        boolean flag = true;
        while (begin < end) {
            char a = s.charAt(begin);
            char b = s.charAt(end);
            if (!Character.isLetter(a) && !Character.isDigit(a)) {
                begin++;
                continue;
            }
            if (!Character.isLetter(b) && !Character.isDigit(b)) {
                end--;
                continue;
            }
            if (Character.isLetter(a) && Character.isLetter(b)) {
                if (Character.toUpperCase(a) -  Character.toUpperCase(b) != 0) return false;
            } else {
                if (a - b != 0) return false;
            }
            begin++;
            end--;
        }
        return flag;
    }
}
