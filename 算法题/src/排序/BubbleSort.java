package 排序;

import java.util.Arrays;

/**
 * @author 彭一鸣
 * @since 2021/4/8 15:51
 */
public class BubbleSort implements IArraySort{

    @Override
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j  + 1]) {
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    flag = true;
                }
            }
            if (!flag) {
                return arr;
            }
        }
        return arr;
    }
}
