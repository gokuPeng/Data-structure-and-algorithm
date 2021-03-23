package 递归;

import java.util.*;

/**
 * @author 彭一鸣 341. 扁平化嵌套列表迭代器 https://leetcode-cn.com/problems/flatten-nested-list-iterator/solution/bian-ping-hua-qian-tao-lie-biao-die-dai-ipjzq/
 * @since 2021/3/23 9:44
 */
public class NestedIterator implements Iterator<Integer> {
    
    private Deque<Integer> stack = new ArrayDeque<>();

//    public NestedIterator(List<NestedInteger> nestedList) {
//        dp(nestedList);
//    }
//
//    private void dp(List<NestedInteger> nestedList) {
//        if (nestedList == null) {
//            return;
//        }
//        for (NestedInteger nestedInteger : nestedList) {
//
//            if (nestedInteger.getInteger() != null) {
//                stack.addLast(nestedInteger.getInteger());
//            } else {
//                dp(nestedInteger.getList());
//            }
//        }
//    }

    @Override
    public Integer next() {
        return stack.pollFirst();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
