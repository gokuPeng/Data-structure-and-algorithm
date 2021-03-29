package 多线程;

import java.util.concurrent.Semaphore;

/**
 * @author 彭一鸣  1115. 交替打印FooBar    https://leetcode-cn.com/problems/print-foobar-alternately/
 * @since 2021/3/29 13:39
 */
public class 交替打印FooBar_信号量 {
    private int n;


    public 交替打印FooBar_信号量(int n) {
        this.n = n;
    }

    private Semaphore sp1 = new Semaphore(1);
    private Semaphore sp2 = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sp1.acquire();
            printFoo.run();
            sp2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            sp2.acquire();
            printBar.run();
            sp1.release();
        }
    }
}
