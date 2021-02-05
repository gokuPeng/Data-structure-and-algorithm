package 链表;

/**
 * @author 彭一鸣  328. 奇偶链表   https://leetcode-cn.com/problems/odd-even-linked-list/
 * @since 2021/2/4 17:35
 */
public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode odd2 = odd;
        ListNode event = new ListNode();
        ListNode event2 = event;
        ListNode cur = head;
        boolean flag = true;
        while (cur != null) {
            if (flag) {
                odd.next = cur;
                odd = cur;
            } else {
                event.next = cur;
                event = cur;
            }
            cur = cur.next;
            flag = !flag;
        }
        odd.next = event2.next;
        event.next = null;
        head = odd2.next;
        return head;
    }
}
