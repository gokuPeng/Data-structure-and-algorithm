package 动态规划;

/**
 * @author 彭一鸣  387. 字符串中的第一个唯一字符   https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @since 2020/12/23 10:16
 */
public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] exitsNum = new int[26];
        for (int i = 0; i < chars.length; i++) {
            exitsNum[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (exitsNum[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
