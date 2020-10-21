package 链表;
// 24. 两两交换链表中的节点 https://leetcode-cn.com/problems/swap-nodes-in-pairs/
public class 两两交换链表中的节点 {
    public static void main(String[] args) {

    }
}
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        // 假设数字是 1 -> 2 -> 3 -> 4
        // 指针则对应 p -> q -> 3 -> 4   cur则是记录pq前面的指针，以防后面的指针丢失
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode cur = new ListNode();
        ListNode result = q;
        while(q != null) {
            p.next = q.next;
            q.next = p;
            cur.next = q;
            ListNode temp = p;
            p = q;
            q = temp;
            cur = q;
            // p、q往后移动
            if (q.next == null) {
                break;
            }
            p = p.next.next;
            q = q.next.next;
        }
        return result;
    }
}
