package 动态规划;

/**
 * @author 彭一鸣  42. 接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
 * @since 2021/1/18 20:34
 */
public class 接雨水 {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int leftMax = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > leftMax) {
                leftMax = height[i - 1];
            }
            left[i] = leftMax;
        }
        int rightMax = 0;
        for (int i = height.length - 1; i >= 1; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            }
            right[i - 1] = rightMax;
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int sub = Math.min(left[i], right[i]) - height[i];
            ans += sub > 0 ? sub : 0;
        }
        return ans;
    }
}
