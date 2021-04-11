package 字符串;

import java.util.Arrays;

/**
 * @author 彭一鸣 179. 最大数 https://leetcode-cn.com/problems/largest-number/
 * @since 2021/4/12 0:20
 */
public class 最大数 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder ans = new StringBuilder();
        for (String string : strings) {
            ans.append(string);
        }
        if (ans.charAt(0) == '0') {
            return "0";
        }
        return ans.toString();
    }
}
