package 二分查找;

/**
 * @author 彭一鸣  167. 两数之和 II - 输入有序数组  https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @since 2020/12/1 19:07
 */
public class 两数之和II {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0, b = -1;
        for (int i = 0; i < numbers.length; i++) {
            a = i;
            b = binarySearch(numbers, target - numbers[i]);
            if (b == -1) {
                continue;
            } else {
                break;
            }
        }
        return new int[] {a + 1, b + 1};
    }

    private int binarySearch(int[] numbers, int target) {
        int begin = 0;
        int end = numbers.length;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            int cmp = target - numbers[mid];
            if (cmp > 0) {
                begin = mid + 1;
            } else if (cmp < 0) {
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
