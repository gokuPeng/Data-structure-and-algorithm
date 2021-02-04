package 贪心;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 彭一鸣  874. 模拟行走机器人  https://leetcode-cn.com/problems/walking-robot-simulation/
 * @since 2021/2/3 16:15
 */
public class 模拟行走机器人 {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 表示机器人的坐标
        int x = 0, y = 0;
        // 机器人的脸朝向，0上 1左 2下 3右
        int face = 0;
        // 最大距离
        int max = 0;
        // 将障碍物转成set值为坐标
        Set<String> set = new HashSet<>();
        Arrays.stream(obstacles).forEach(obstacle -> {
            set.add(obstacle[0] + "," + obstacle[1]);
        });
        for (int command : commands) {
            if (command == -2) {
                face = (face + 1) % 4;
            } else if (command == -1) {
                face = (face + 3) % 4;
            } else {
                int i;
                switch (face) {
                    case 0:
                        // 向上走，即 y+i
                        for (i = 1; i <= command; i++) {
                            int temp = y + i;
                            if (set.contains(x + "," + temp)) {
                                break;
                            }
                        }
                        y += i - 1;
                        break;
                    case 1:
                        // 向左走，即 x-i
                        for (i = 1; i <= command; i++) {
                            int temp = x - i;
                            if (set.contains(temp + "," + y)) {
                                break;
                            }
                        }
                        x -= i - 1;
                        break;
                    case 2:
                        // 向下走，即 y-i
                        for (i = 1; i <= command; i++) {
                            int temp = y - i;
                            if (set.contains(x + "," + temp)) {
                                break;
                            }
                        }
                        y -= i - 1;
                        break;
                    case 3:
                        // 向右走，即 x+i
                        for (i = 1; i <= command; i++) {
                            int temp = x + i;
                            if (set.contains(temp + "," + y)) {
                                break;
                            }
                        }
                        x += i - 1;
                        break;
                    default:
                        break;
                }
                max = Math.max(x * x + y * y, max);
            }
        }
        return max;
    }
}
