package 链表;

// (2 -> 4 -> 3) + (5 -> 6 -> 4) 输出7 -> 0 -> 8
// 2 两数相加 https://leetcode-cn.com/problems/add-two-numbers/
public class 两数相加 {

}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l = new ListNode();
        ListNode head = l;
        int carry = 0;
        while(l1 != null || l2 != null) {
            if (l1 != null && l2 == null) {
                int sum = l1.val + carry;
                carry = sum/10;
                ListNode listNode = new ListNode(sum % 10);
                l.next = listNode;
                l = l.next;
                l1 = l1.next;
            } else if (l2 != null && l1 == null) {
                int sum = l2.val + carry;
                carry = sum/10;
                ListNode listNode = new ListNode(sum % 10);
                l.next = listNode;
                l = l.next;
                l2 = l2.next;
            } else {
                int sum = l1.val + l2.val + carry;
                carry = sum/10;
                ListNode listNode = new ListNode(sum % 10);
                l.next = listNode;
                l = l.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            ListNode listNode = new ListNode(carry);
            l.next = listNode;
        }
        return head.next;
    }
}