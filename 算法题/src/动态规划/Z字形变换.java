package 动态规划;

import java.util.Arrays;

/**
 * @author 彭一鸣
 * @since 2020/12/23 10:41
 */
public class Z字形变换 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[] chars = s.toCharArray();
        int[] order = new int[chars.length];
        boolean flag = true;
        for (int i = 0, j = 0; i < chars.length; i++) {
            order[i] = j;
            if (flag) {
                if (j < numRows - 1) {
                    j++;
                } else {
                    j--;
                    flag = false;
                }
            } else {
                if (j > 0) {
                    j--;
                } else {
                    j++;
                    flag = true;
                }
            }
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
            System.out.println(i);
        }
        for (int i = 0; i < chars.length; i++) {
            sb[order[i]].append(chars[i]);
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder stringBuilder : sb) {
            ans.append(stringBuilder);
        }
        return ans.toString();
    }
}
