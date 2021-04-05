package 数组;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 彭一鸣 57. 插入区间 https://leetcode-cn.com/problems/insert-interval/
 * @since 2021/4/5 14:27
 */
public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int[][] array = new int[intervals.length + 1][1];
        System.arraycopy(intervals, 0, array, 0, intervals.length);
        array[array.length - 1] = newInterval;
        Arrays.sort(array, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i][0] > list.get(list.size() - 1)[1]) {
                // 如果两个区间分开
                list.add(new int[] {
                        array[i][0], array[i][1]
                });
                continue;
            }
            if (array[i][0] >= list.get(list.size() - 1)[0] && array[i][0] <= list.get(list.size() - 1)[1] && array[i][1] > list.get(list.size() - 1)[1]) {
                // 如果两个区间有交叉，比如 1__3 2__4或者1__4 4__5或者1__4 1__5，只留第一个和最后一个
                list.get(list.size() - 1)[1] = array[i][1];
            }
            // 如果在他之内，啥也不管
        }
        return list.toArray(new int[0][]);
    }
}
