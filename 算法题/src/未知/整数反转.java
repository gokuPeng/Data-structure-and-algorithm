package 未知;

import java.math.BigDecimal;

/**
 * @author 彭一鸣  https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
 * @since 2020/12/1 19:45
 */
public class 整数反转 {
    public int reverse(int x) {
        if (x >= 0) {
            StringBuilder sb = new StringBuilder(new Integer(x).toString());
            StringBuilder reverse = sb.reverse();
            BigDecimal num = new BigDecimal(reverse.toString());
            if (num.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
                return 0;
            } else {
                return new Integer(sb.toString());
            }
        } else {
            StringBuilder sb = new StringBuilder(new Integer(x).toString());
            sb.deleteCharAt(0);
            sb.reverse();
            sb.insert(0, '-');
            BigDecimal num = new BigDecimal(sb.toString());
            if (num.compareTo(new BigDecimal(Integer.MIN_VALUE)) < 0) {
                return 0;
            } else {
                return new Integer(sb.toString());
            }
        }
    }
}
