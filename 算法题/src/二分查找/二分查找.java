package 二分查找;

/**
 * @author 彭一鸣
 * @since 2020/11/13 17:43
 */
// https://leetcode-cn.com/problems/binary-search/
public class 二分查找 {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        while (begin < end) {
            int cmp = (begin + end) >> 1;
            if (target > nums[cmp]) {
                begin = cmp + 1;
            } else if (target < nums[cmp]){
                end = cmp - 1;
            } else {
                return cmp;
            }
            System.out.println(begin);
            System.out.println(end);
        }
        return -1;
    }
}
