package 数组;

/**
 * @author 彭一鸣  58. 最后一个单词的长度   https://leetcode-cn.com/problems/length-of-last-word/
 * @since 2021/1/4 17:31
 */
public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int lenth = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                lenth++;
            } else if (c == ' ' && lenth != 0){
                break;
            }
        }
        return lenth;
    }
}
