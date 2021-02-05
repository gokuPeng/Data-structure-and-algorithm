package 数组;

/**
 * @author 彭一鸣 717. 1比特与2比特字符 https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * @since 2021/2/5 17:20
 */
public class _1比特与2比特字符 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (; i < bits.length - 1; i++) {
            if (bits[i] == 1) {
                i++;
            }
        }
        return i == bits.length - 1;
    }
}
