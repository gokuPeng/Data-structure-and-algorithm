package 位运算;

/**
 * @author 彭一鸣 191. 位1的个数 https://leetcode-cn.com/problems/number-of-1-bits/
 * @since 2021/3/22 10:46
 */
public class 位1的个数 {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
