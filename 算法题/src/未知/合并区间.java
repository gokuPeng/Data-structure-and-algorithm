package 未知;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 彭一鸣 56. 合并区间 https://leetcode-cn.com/problems/merge-intervals/
 * @since 2020/12/14 9:32
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return null;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {
                intervals[0][0], intervals[0][1]
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > list.get(list.size() - 1)[1]) {
                // 如果两个区间分开
                list.add(new int[] {
                        intervals[i][0], intervals[i][1]
                });
                continue;
            }
            if (intervals[i][0] >= list.get(list.size() - 1)[0] && intervals[i][0] <= list.get(list.size() - 1)[1] && intervals[i][1] > list.get(list.size() - 1)[1]) {
                // 如果两个区间有交叉，比如 1__3 2__4或者1__4 4__5或者1__4 1__5，只留第一个和最后一个
                list.get(list.size() - 1)[1] = intervals[i][1];
            }
            // 如果在他之内，啥也不管
        }
        return list.toArray(new int[list.size()][]);
    }
}
