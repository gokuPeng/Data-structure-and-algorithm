package 排序;

/**
 * @author 彭一鸣
 * @since 2021/4/8 16:26
 */
public class SelectionSort implements IArraySort {

    @Override
    public int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 找到最小值
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i] ^ arr[minIndex];
                arr[i] = arr[i] ^ arr[minIndex];
                arr[minIndex] = arr[i] ^ arr[minIndex];
            }
        }

        return arr;
    }
}
