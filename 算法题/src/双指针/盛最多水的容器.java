package 双指针;

/**
 * @author 彭一鸣  11. 盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water/
 * @since 2020/12/23 14:39
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int begin = 0;
        int end = height.length - 1;
        int max = 0;
        while (begin <= end) {
            if (height[begin] >= height[end]) {
                max = Math.max(max, height[end] * (end - begin));
                end--;
            } else {
                max = Math.max(max, height[begin] * (end - begin));
                begin++;
            }
        }
        return max;
    }
}
