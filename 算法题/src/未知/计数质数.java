package 未知;

import java.util.Arrays;

/**
 * @author 彭一鸣  204. 计数质数  https://leetcode-cn.com/problems/count-primes/
 * @since 2020/12/3 16:39
 */
public class 计数质数 {
    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                num++;
            }
            for (int j = i + i; j < n; j = j + i) {
                flag[j] = false;
            }
        }
        return num;
    }
}
