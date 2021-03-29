package 多线程;

import java.util.function.IntConsumer;

/**
 * @author 彭一鸣  1116. 打印零与奇偶数   https://leetcode-cn.com/problems/print-zero-even-odd/
 * @since 2021/3/29 14:33
 */
public class 打印零与奇偶数_自旋 {
    private int n;

    public 打印零与奇偶数_自旋(int n) {
        this.n = n;
    }
    private volatile int atomicInteger;
    private volatile boolean flag = true;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (atomicInteger != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            atomicInteger = flag ? 2 : 1;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (atomicInteger != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            atomicInteger = 0;
            flag = true;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (atomicInteger != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            atomicInteger = 0;
            flag = false;
        }
    }
}
