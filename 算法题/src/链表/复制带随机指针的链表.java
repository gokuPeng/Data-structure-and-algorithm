package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 彭一鸣 138. 复制带随机指针的链表  https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * @since 2021/3/8 16:59
 */
public class 复制带随机指针的链表 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap();
        Node headCopy = new Node(head.val);
        map.put(head, headCopy);
        Node cur = head.next;
        Node curCopy = headCopy;
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            curCopy.next = node;
            curCopy = node;
            cur = cur.next;
        }
        cur = head;
        curCopy = headCopy;
        while (cur != null) {
            Node random = cur.random;
            curCopy.random = random != null ? map.get(random) : null;
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return headCopy;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
