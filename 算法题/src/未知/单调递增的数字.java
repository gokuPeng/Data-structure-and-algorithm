package 未知;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭一鸣  https://leetcode-cn.com/problems/monotone-increasing-digits/
 * @since 2020/12/15 19:34
 */
public class 单调递增的数字 {
    public int monotoneIncreasingDigits(int N) {
        List<Integer> list = new ArrayList<>();
        while(N > 0) {
            list.add(N % 10);
            N /= 10;
        }
        StringBuilder sb = new StringBuilder();
        int lenth = list.size();
        for (int i = lenth - 1; i >= 1; i--) {
            Integer pop = list.get(i);
            if (pop < list.get(i - 1)) {
                sb.append(pop);
            } else if (pop > list.get(i - 1)){
                sb.append(pop - 1);
                for (int j = i; j > 0; j--) {
                    sb.append(9);
                }
                break;
            } else {
                // 此时这位数和下一个数相等
                // 那么判断它会不会一直相等到递减，如果会，则第一个数减一，后面全部赋值99999
                // 如果不会一直递减，那就把添加
                boolean flag = false;
                for (int j = i; j > 1; j--) {
                    if (list.get(i) > list.get(j - 1)) {
                        flag = true;
                        break;
                    }
                    if (list.get(i) < list.get(j - 1)) {
                        break;
                    }
                }
                if (!flag) {
                    sb.append(pop);
                } else {
                    sb.append(pop - 1);
                    for (int j = i; j > 0; j--) {
                        sb.append(9);
                    }
                    break;
                }
            }
        }
        if (sb.length() != lenth) sb.append(list.get(0));
        return new Integer(sb.toString());
    }
}
