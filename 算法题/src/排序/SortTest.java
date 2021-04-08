package 排序;

import java.util.Arrays;

/**
 * @author 彭一鸣
 * @since 2021/4/8 16:48
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
//        IArraySort bubbleSort = new BubbleSort();
//        bubbleSort.sort(arr);

//        IArraySort selectSort = new SelectionSort();
//        selectSort.sort(arr);

//        IArraySort insertSort = new InsertionSort();
//        insertSort.sort(arr);

        IArraySort shellSort = new ShellSort();
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copyArr);
        shellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(copyArr));
    }
}
