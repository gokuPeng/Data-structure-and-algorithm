package 链表;

/**
 * @author 彭一鸣 61. 旋转链表 https://leetcode-cn.com/problems/rotate-list/
 * @since 2020/12/11 15:50
 */
public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }
        cur.next = head;
        int num = size - k % size;
        cur = head;
        for (; num >= 1; num--) {
            cur = cur.next;
        }
        head = cur;
        // 断开连接
        for (; size > 1; size--) {
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
}
