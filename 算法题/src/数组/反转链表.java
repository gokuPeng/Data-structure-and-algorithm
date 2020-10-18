package 数组;

import java.util.List;

// 206 反转链表 | Reverse Linked List https://leetcode-cn.com/problems/reverse-linked-list/
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode q = head;
        while (q != null) {
            ListNode t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        return p;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
