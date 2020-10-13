package 数组;
// 268. 缺失数字 https://leetcode-cn.com/problems/missing-number/
public class 缺失数字 {
    public static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length + 1; i++) {
            boolean flag = false; // false表示i不存在nums中
            for (int j = 0; j < nums.length; j++) {
                // 如果i存在nums[j]中
                if (i == nums[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
        System.out.println(i);
    }
}
