package 未知;

/**
 * @author 彭一鸣 1017. 负二进制转换 https://leetcode-cn.com/problems/convert-to-base-2/solution/fu-er-jin-zhi-biao-shi-fa-go-java-by-leovip/
 * @since 2021/4/6 19:44
 */
public class 负二进制转换 {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        while (N != 0) {
            int i = N % 2;
            if (N < 0 && i != 0) {
                N = N / -2 + 1;
            } else {
                N = N / -2;
            }
            ans.append(Math.abs(i));
        }
        return ans.reverse().toString();
    }
}
