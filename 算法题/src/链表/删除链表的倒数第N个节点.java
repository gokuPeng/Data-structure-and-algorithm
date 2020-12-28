package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭一鸣
 * @since 2020/12/23 14:51
 */
public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        // 删除倒数第n个，即list.size() - n
        if (n == list.size()) {
            head = head.next;
        } else if (n == 1) {
            list.get(list.size() - 2).next = null;
        } else {
            list.get(list.size() - n - 1).next = list.get(list.size() - n + 1);
        }
        return head;
    }
}
