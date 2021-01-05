package 双指针;

import 链表.ListNode;

/**
 * @author 彭一鸣
 * @since 2021/1/4 17:16
 */
public class 删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        int lastNum = -1;
        ListNode lastNode = new ListNode();
        while(p != null) {
            int curNum = p.val;
            if (lastNum == curNum) {
                lastNode.next = p.next;
            } else {
                lastNode = p;
            }
            lastNum = curNum;
            p = p.next;
        }
        return head;
    }
}
