package 数组;
// https://leetcode-cn.com/problems/two-sum/
public class 两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        // 从nums中从第一个道最后一个遍历
        for (int i = 0; i < nums.length; i++) {
            // 当其中一位数为nums[i]的时候，另外一位数应该为target-nums[i]
            for (int j = 0; j < nums.length; j++) {
                // 寻找到另外一位数, 必须排除自己
                if (i != j && target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
