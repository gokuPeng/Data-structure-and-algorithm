package 链表;

// 21 合并两个有序链表 | Merge Two Sorted Lists https://leetcode-cn.com/problems/merge-two-sorted-lists/
public class 合并两个有序链表 {
    public static void main(String[] args) {

    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode21 {
    int val;
    ListNode21 next;
    ListNode21() {}
    ListNode21(int val) { this.val = val; }
    ListNode21(int val, ListNode21 next) { this.val = val; this.next = next; }
}
class Solution21 {
    public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
        ListNode21 l3 = new ListNode21();
        ListNode21 head = l3;
        while (l1 != null || l2 != null) {
            if (l2 == null && l1 != null) {
                ListNode21 l = new ListNode21(l1.val);
                l3.next = l;
                l3 = l;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                ListNode21 l = new ListNode21(l2.val);
                l3.next = l;
                l3 = l;
                l2 = l2.next;
            } else {
                if (l1.val < l2.val) {
                    ListNode21 l = new ListNode21(l1.val);
                    l3.next = l;
                    l3 = l;
                    l1 = l1.next;
                } else {
                    ListNode21 l = new ListNode21(l2.val);
                    l3.next = l;
                    l3 = l;
                    l2 = l2.next;
                }
            }
        }
        return head.next;
    }
}