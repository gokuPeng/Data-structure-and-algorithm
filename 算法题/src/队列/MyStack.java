package 队列;

import java.util.LinkedList;
import java.util.Queue;
// 225. 用队列实现栈 https://leetcode-cn.com/problems/implement-stack-using-queues/submissions/
class MyStack {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            Integer poll = queue.poll();
            queue.offer(poll);
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            Integer poll = queue.poll();
            queue.offer(poll);
        }
        Integer poll = queue.poll();
        queue.offer(poll);
        return poll;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
