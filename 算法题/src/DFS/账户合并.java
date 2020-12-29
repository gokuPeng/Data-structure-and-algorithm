package DFS;

import java.util.*;

/**
 * @author 彭一鸣 721. 账户合并 https://leet   code-cn.com/problems/accounts-merge/
 * @since 2020/11/30 18:11
 */
public class 账户合并 {

    private List<List<String>> result = new ArrayList<>();
    private List<List<String>> accounts = new ArrayList<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        this.accounts = accounts;
        if (this.accounts == null || this.accounts.size() == 0) return result;
        for (int i = 0; i < this.accounts.size(); i++) {
            dfs(i);
            if (this.accounts.get(i).size() > 0) result.add(this.accounts.get(i));
        }
        return result;
    }

    private void dfs(int index) {
        if (index >= accounts.size() || accounts.get(index).size() == 0) return;
        // 先拿到第一个
        List<String> first = accounts.get(index);
        HashSet<String> set = new HashSet<>(first.subList(1, first.size()));
        String name = first.get(0);
        for (int i = index + 1; i < accounts.size(); i++) {
            // 看后面的有没有同样的，有就往后合并
            List<String> last = accounts.get(i);
            for (int j = 1; j < last.size(); j++) {
                if (first.contains(last.get(j))) {
                    set.addAll(last.subList(1, last.size()));
                    // 此时set是合并了的，但是没有name
                    // 清空last，把set放上去
                    last.clear();
                    last.add(name);
                    ArrayList<String> afterName = new ArrayList<>(set);
                    Collections.sort(afterName);
                    last.addAll(afterName);
                    first.clear();
                    dfs(j);
                    return;
                }
            }
        }
        first.clear();
        first.add(name);
        ArrayList<String> afterName = new ArrayList<>(set);
        Collections.sort(afterName);
        first.addAll(afterName);
    }
}
