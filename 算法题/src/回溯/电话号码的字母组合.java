package 回溯;

import java.util.*;

/**
 * @author 彭一鸣  17. 电话号码的字母组合  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/submissions/
 * @since 2020/11/20 22:46
 */
public class 电话号码的字母组合 {

    List<String> result = new LinkedList<>();
    Map<Character, List<String>> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return result;

        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r" , "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        char[] nums = new char[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            nums[i] = digits.charAt(i);
        }
        selectCombinations(nums, 0);
        return result;
    }

    private void selectCombinations(char[] nums, int index) {
        if (sb.length() == nums.length) {
            result.add(sb.toString());
            return;
        }
        List<String> list = map.get(nums[index]);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            selectCombinations(nums, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
