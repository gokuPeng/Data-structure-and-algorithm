package 贪心;

/**
 * @author 彭一鸣 134. 加油站 https://leetcode-cn.com/problems/gas-station/
 * @since 2021/2/4 10:47
 */
public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] num = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            num[i] = gas[i] - cost[i];
        }
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            int j = i;
            for (; j < i + num.length; j++) {
                sum += num[j % num.length];
                if (sum < 0) {
                    // 我们首先检查第 0个加油站，并试图判断能否环绕一周；如果不能，就从第一个无法到达的加油站开始继续检查
                    i = j;
                    break;
                }
            }
            if (j == i + num.length) {
                return i;
            }
        }
        return -1;
    }
}
