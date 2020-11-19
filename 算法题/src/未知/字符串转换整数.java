package 未知;

import java.math.BigInteger;

/**
 * @author 彭一鸣 8. 字符串转换整数 (atoi) https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @since 2020/11/19 17:32
 */
public class 字符串转换整数 {
    public int myAtoi(String s) {
        int i;
        s = s.replace(' ', '*');
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                break;
            }
        }
        if (s.length() == i) return 0;
        if (s.length() == i + 1 && Character.isDigit(s.charAt(0))) return new Integer(new String (s.getBytes()));
        if (s.length() == i + 2 && (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-')) return 0;
        StringBuilder sb = new StringBuilder();
        if (Character.isDigit(s.charAt(i))) {
            for (int j = i; j < s.length(); j++) {
                char cur = s.charAt(j);
                if (!Character.isDigit(cur)) {
                    break;
                } else {
                    sb.append(cur);
                }
            }
            String result = sb.toString();
            BigInteger a = new BigInteger("result");
            if (a.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) >= 0) return Integer.MAX_VALUE;
            Integer integer = new Integer(result);
            return integer;
        } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (!Character.isDigit(s.charAt(i + 1))) return 0;
            for (int j = i + 1; j < s.length(); j++) {
                char cur = s.charAt(j);
                if (!Character.isDigit(cur)) {
                    break;
                } else {
                    sb.append(cur);
                }
            }
            String result = sb.toString();
            if (result.length() == 0) return 0;
            BigInteger b = new BigInteger(result);
            if (s.charAt(i) == '+') {
                if (b.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) >= 0) return Integer.MAX_VALUE;
            } else {
                if (b.compareTo(BigInteger.valueOf(Integer.MAX_VALUE + 1L)) >= 0) return Integer.MIN_VALUE;
            }
            Integer integer = new Integer(result);
            return s.charAt(i) == '+' ? integer : 0 - integer;
        } else {
            return 0;
        }
    }
}
