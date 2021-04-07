package 双指针;

/**
 * @author 彭一鸣 面试题 17.21. 直方图的水量 https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 * @since 2021/4/8 0:29
 */
public class 直方图的水量 {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int ans = 0;
        int[] l = new int[height.length];
        int[] r = new int[height.length];
        int max = l[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            l[i] = max;
        }
        max = r[r.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            r[i] = max;
        }
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(l[i], r[i]) - height[i];
        }
        return ans;
    }
}
