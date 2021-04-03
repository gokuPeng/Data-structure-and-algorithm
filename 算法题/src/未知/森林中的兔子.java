package 未知;

import java.util.Arrays;

/**
 * @author 彭一鸣 781. 森林中的兔子 https://leetcode-cn.com/problems/rabbits-in-forest/
 * @since 2021/4/4 1:23
 */
public class 森林中的兔子 {
    public int numRabbits(int[] answers) {
        int ans = 0;
        Arrays.sort(answers);
        int num = 0;
        int lastNum = -1;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] != lastNum || answers[i] == 0) {
                num = 1;
                ans += answers[i] + 1;
                lastNum = answers[i];
            } else if (answers[i] == lastNum) {
                num++;
                // 判断是不是最后一个
                if (num == lastNum + 1) {
                    // 如果是最后一个，将lastNum变掉
                    lastNum = -1;
                }
            }
        }
        return ans;
    }
}
