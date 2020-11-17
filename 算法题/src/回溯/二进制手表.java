package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭一鸣  401. 二进制手表  https://leetcode-cn.com/problems/binary-watch/
 * @since 2020/11/17 8:50
 */
public class 二进制手表 {
    List<String> result;

    public List<String> readBinaryWatch(int num) {
        result = new ArrayList<String>();
        //判断输入
        if (num < 0)
            return result;
        //LED灯，前四个为小时，后六个为分钟
        int[] nums = new int[]{8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        backTrack(num, nums, 0, 0, 0);
        return result;
    }

    public void backTrack(int num, int[] nums, int start, int hour, int minute) {
        if (num == 0) {
            //判断时间是否正确
            if(hour>11||minute>59)
                return;
            StringBuilder tmp=new StringBuilder();
            //小时
            tmp.append(hour);
            tmp.append(":");
            //分钟
            if(minute<10)
                tmp.append(0);
            tmp.append(minute);
            result.add(new String(tmp));
            return ;
        }
        for (int i = start; i < nums.length; i++) {
            if (i < 4) { // 说明选的是小时
                hour += nums[i];
            } else {    // 说明选的是分钟
                minute += nums[i];
            }
            backTrack(num - 1, nums, i + 1, hour, minute);
            if (i < 4) {
                hour -= nums[i];
            } else {
                minute -= nums[i];
            }
        }
    }
}
