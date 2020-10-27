package 栈;

// 232. 用栈实现队列 https://leetcode-cn.com/problems/implement-queue-using-stacks/
import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
            stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (stack1.size() > 0) {
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        Integer result = stack2.pop();
        while (stack2.size() > 0) {
            Integer pop = stack2.pop();
            stack1.push(pop);
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        while (stack1.size() > 0) {
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        Integer result = stack2.peek();
        while (stack2.size() > 0) {
            Integer pop = stack2.pop();
            stack1.push(pop);
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */