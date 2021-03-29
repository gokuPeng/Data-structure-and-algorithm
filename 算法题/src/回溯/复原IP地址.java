package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭一鸣 93. 复原 IP 地址 https://leetcode-cn.com/problems/restore-ip-addresses/
 * @since 2021/3/29 20:10
 */
public class 复原IP地址 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() > 12) return ans;
        dfs(s,new ArrayList<>(),0, 0,ans);
        return ans;
    }

    private void dfs(String s, List<String> subAns, int count, int index, List<String> ans) {
        if (count == 4 && index == s.length()) {
            String s2 = subAns.toString();
            ans.add(s2.substring(1, s2.length() - 1).replace(',','.').replaceAll(" ", ""));
            return;
        }
        for (int i = 1; i < 4; i++) {
            String sub = i + index <= s.length() ? s.substring(index, i + index) : "256";
            if (new Integer(sub) < 256) {
                if (i > 1) {
                    if (sub.charAt(0) == '0') {
                        continue;
                    }
                }
                subAns.add(sub);
            } else {
                break;
            }
            dfs(s, subAns, ++count, index + i, ans);
            count--;
            subAns.remove(subAns.size() - 1);
        }
    }

}
