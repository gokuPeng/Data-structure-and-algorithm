package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 彭一鸣 1114. 按序打印 https://leetcode-cn.com/problems/print-in-order/
 * @since 2021/3/29 9:55
 */
public class 按序打印 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition cd1 = lock.newCondition();
    private Condition cd2 = lock.newCondition();
    volatile boolean a = false;
    volatile boolean b = false;
    volatile boolean c = false;

    public 按序打印() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            a = true;
            cd1.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            // printSecond.run() outputs "second". Do not change or remove this line.
            if (!a) {
                cd1.await();
            }
            printSecond.run();
            b = true;
            cd2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            if (!b) {
                cd2.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
