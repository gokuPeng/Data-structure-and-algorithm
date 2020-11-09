package 双指针;

// 344. 反转字符串 https://leetcode-cn.com/problems/reverse-string/

public class 反转字符串 {
    public void reverseString(char[] s) {
        int begin = 0;
        int end = s.length - 1;
        char temp;
        while (begin < end) {
            temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
    }
}
