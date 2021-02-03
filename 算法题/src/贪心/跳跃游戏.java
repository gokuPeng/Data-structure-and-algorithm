package 贪心;

/**
 * @author 彭一鸣 55. 跳跃游戏 https://leetcode-cn.com/problems/jump-game/
 * @since 2021/2/3 11:49
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int i = 0;
        for (; i < nums.length; ) {
            // 从nums[i]跳到1 ... nums[i]能够跳到的最远的地方
            int maxIndex = 0;
            int max = i + nums[i];
            boolean flag = false;
            for (int j = i + 1;j < nums.length && j <= max; j++) {
                if (nums[j] + j >= maxIndex) {
                    i = j;
                    maxIndex = nums[j] + j;
                    flag = true;
                }
            }
            if (i + 1 == nums.length) {
                return true;
            }
            if (!flag) {
                return false;
            }
        }
        return false;
    }
}
