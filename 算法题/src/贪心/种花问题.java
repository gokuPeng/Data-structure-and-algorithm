package 贪心;

/**
 * @author 彭一鸣  605. 种花问题   https://leetcode-cn.com/problems/can-place-flowers/
 * @since 2021/2/3 10:43
 */
public class 种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 ? n <= 1 : false;
        }
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 1) {
                i += 1;
                continue;
            } else {
                if (i > 0 && i < flowerbed.length - 1) {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        ++i;
                        n--;
                    }
                } else if (i == 0 && i < flowerbed.length) {
                    if (flowerbed[i + 1] == 0) {
                        ++i;
                        n--;
                    }
                } else if (i > 0 && i == flowerbed.length - 1){
                    if (flowerbed[i - 1] == 0) {
                        ++i;
                        n--;
                    }
                }
            }
        }
        return n <= 0;
    }
}
