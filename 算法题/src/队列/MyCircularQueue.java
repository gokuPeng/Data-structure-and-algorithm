package 队列;
// 622. 设计循环队列 https://leetcode-cn.com/problems/design-circular-queue/
class MyCircularQueue {

    // 队列
    private int[] queue;

    // 队头
    private int front = 0;

    //队列的长度
    private int size = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        // 要插入的索引
        int insertIndex = (front + size) % queue.length;
        queue[insertIndex] = value;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % queue.length;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;
        int rearIndex = (front + size - 1) % queue.length;
        return queue[rearIndex];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }
}
