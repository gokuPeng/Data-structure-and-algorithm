package 未知;

/**
 * @author 彭一鸣 38. 外观数列 https://leetcode-cn.com/problems/count-and-say/
 * @since 2020/12/8 15:10
 */
public class 外观数列 {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        int count = 1;
        for (int i = 2; i <= n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < sb.length(); j++) {
                if (j < sb.length() - 1 && sb.charAt(j) == sb.charAt(j + 1)) {
                    count++;
                } else {
                    s.append(count);
                    s.append(sb.charAt(j));
                    count = 1;
                }
            }
            sb = s;
        }
        return sb.toString();
    }
}
