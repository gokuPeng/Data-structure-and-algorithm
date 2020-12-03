package 未知;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 彭一鸣  13. 罗马数字转整数  https://leetcode-cn.com/problems/roman-to-integer/
 * @since 2020/12/3 15:29
 */
public class 罗马数字转整数 {
    public int romanToInt(String s) {
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i > 0) {
                if (s.charAt(i - 1) == 'I') {
                    if (s.charAt(i) == 'V') {
                        num += 4;
                        i--;
                        continue;
                    }
                    if (s.charAt(i) == 'X') {
                        num += 9;
                        i--;
                        continue;
                    }
                }
                if (s.charAt(i - 1) == 'X') {
                    if (s.charAt(i) == 'L') {
                        num += 40;
                        i--;
                        continue;
                    }
                    if (s.charAt(i) == 'C') {
                        num += 90;
                        i--;
                        continue;
                    }
                }
                if (s.charAt(i - 1) == 'C') {
                    if (s.charAt(i) == 'D') {
                        num += 400;
                        i--;
                        continue;
                    }
                    if (s.charAt(i) == 'M') {
                        num += 900;
                        i--;
                        continue;
                    }
                }
            }
            switch (s.charAt(i)) {
                case 'I':
                    num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
            }
        }
        return num;
    }
}
