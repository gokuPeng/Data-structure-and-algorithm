package 位运算;

/**
 * @author 彭一鸣
 * @since 2021/3/29 8:35
 */
public class 颠倒二进制位 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans |= (1 & n) << i;
            n = n >>> 1;
        }
        return ans;
    }
}
