package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 彭一鸣  https://leetcode-cn.com/problems/non-decreasing-array/solution/fei-di-jian-shu-lie-by-leetcode-solution-zdsm/
 * @since 2021/2/7 12:14
 */
public class 非递减数列 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(nums[0]);
        // flase目前为止是单调递增
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (flag) {
                if (nums[i] < deque.getLast()) {
                    return false;
                } else {
                    deque.addLast(nums[i]);
                }
            } else {
                if (i < nums.length - 1 && nums[i] < deque.getLast()) {
                    Integer top = deque.removeLast();
                    // 判断这个数字和上上个是不是非递减的
                    if (deque.size() > 0 && nums[i] < deque.getLast()) {
                        // 比如 2 4 1 9，这个1和2还不能构成非递减，那么尝试把1去掉,比较49;
                        if (nums[i + 1] > top) {
                            deque.addLast(nums[i]);
                        } else {
                            return false;
                        }
                    }
                    flag = true;
                }
                deque.addLast(nums[i]);
            }
        }
        return true;
    }
}
