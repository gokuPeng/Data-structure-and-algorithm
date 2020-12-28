package 未知;

/**
 * @author 彭一鸣  1390. 四因数  https://leetcode-cn.com/problems/four-divisors/
 * @since 2020/12/28 16:32
 */
public class 四因数 {

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
             sum += count(nums[i]);
        }
        return sum;
    }

    private int count(int num) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if ((double)num / i - (num / i) == 0) {
                if (i == num / i) {
                    count++;
                    sum += i;
                } else {
                    count += 2;
                    sum += i + num / i;
                }
                if (count > 4) {
                    break;
                }
            }
        }
        return count == 4 ? sum : 0;
    }
}
