package 排序;

/**
 * @author 彭一鸣
 * @since 2021/4/9 0:11
 */
public class ShellSort implements IArraySort {

    @Override
    public int[] sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 里面其实就是插入排序,第一组的第二个元素的索引是gap
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                // 手里还有i/gap张手牌,默认插入位置为i
                int j = i;
                while (j / gap > 0 && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
        return arr;
    }
}
