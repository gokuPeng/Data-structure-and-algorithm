package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 彭一鸣  1115. 交替打印FooBar    https://leetcode-cn.com/problems/print-foobar-alternately/
 * @since 2021/3/29 13:39
 */
public class 交替打印FooBar_可重入锁_Condition {
    private int n;

    public 交替打印FooBar_可重入锁_Condition(int n) {
        this.n = n;
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition cd = lock.newCondition();
    private volatile boolean flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                if (!flag) {
                    cd.await();
                }
                printFoo.run();
                flag = false;
                cd.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                if (flag) {
                    cd.await();
                }
                printBar.run();
                flag = true;
                cd.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
