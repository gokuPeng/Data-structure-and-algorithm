package 贪心;

/**
 * @author 彭一鸣  376. 摆动序列 https://leetcode-cn.com/problems/wiggle-subsequence/
 * @since 2021/2/4 14:49
 */
public class 摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int ans = 1;
        // 找到最后一个转折点
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // 如果后面的这个逼大于前面的这个逼
                // 那么就去找到第一个递增的数字
                for (int j = i; j < nums.length; j++) {
                    if (j == nums.length - 1) {
                        if (nums[j] != nums[j - 1]) {
                            ans += 1;
                            i = j;
                            break;
                        }
                    } else {
                        if (nums[j] > nums[j + 1]) {
                            ans += 1;
                            i = j;
                            break;
                        }
                    }
                }
            } else if (nums[i] < nums[i - 1]) {
                for (int j = i; j < nums.length; j++) {
                    if (j == nums.length - 1) {
                        if (nums[j] != nums[j - 1]) {
                            ans += 1;
                            i = j;
                            break;
                        }
                    } else {
                        if (nums[j] < nums[j + 1]) {
                            ans += 1;
                            i = j;
                            break;
                        }
                    }
                }
            } else {
                // 找到下一个不等的
                for (int j = i; j < nums.length; j++) {
                    if (j == nums.length - 1) {
                        if (nums[j] != nums[j - 1]) {
                            ans += 1;
                            i = j;
                            break;
                        }
                    } else {
                        if (nums[j] != nums[j - 1]) {
                            ans += 1;
                            i = j;
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
