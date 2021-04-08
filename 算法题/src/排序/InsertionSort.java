package 排序;

/**
 * @author 彭一鸣
 * @since 2021/4/8 16:58
 */
public class InsertionSort implements IArraySort {

    @Override
    public int[] sort(int[] arr) {
        // 默认手里有一张手牌，从第二张抽卡到最后一张
        for (int i = 1; i < arr.length; i++) {
            // 手牌数量为i,同时也是默认插入位置
            int j = i;

            while (j > 0 && arr[j - 1] > arr[i]) {
                j--;
            }

            if (j != i) {
                int temp = arr[i];
                System.arraycopy(arr, j, arr, j + 1, i - j);
                arr[j] = temp;
            }
        }
        return arr;
    }
}
