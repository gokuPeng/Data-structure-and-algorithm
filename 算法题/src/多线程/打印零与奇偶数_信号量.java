package 多线程;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author 彭一鸣  1116. 打印零与奇偶数   https://leetcode-cn.com/problems/print-zero-even-odd/
 * @since 2021/3/29 14:33
 */
public class 打印零与奇偶数_信号量 {
    private int n;

    public 打印零与奇偶数_信号量(int n) {
        this.n = n;
    }

    private Semaphore sp1 = new Semaphore(1);
    private Semaphore sp2 = new Semaphore(0);
    private Semaphore sp3 = new Semaphore(1);
    private volatile boolean flag = true;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            sp1.acquire();
            printNumber.accept(0);
            if (flag) {
                sp3.release();
            } else {
                sp2.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            sp2.acquire();
            printNumber.accept(i);
            flag = true;
            sp1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            sp3.acquire();
            printNumber.accept(i);
            flag = false;
            sp1.release();
        }
    }
}
