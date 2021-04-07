package 多线程;

import java.util.concurrent.Semaphore;

/**
 * @author 彭一鸣 1117. H2O 生成 https://leetcode-cn.com/problems/building-h2o/
 * @since 2021/4/8 0:47
 */
public class H2O {

    private Semaphore sp1 = new Semaphore(2);
    private Semaphore sp2 = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        sp1.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        sp2.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        sp2.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        sp1.release(2);
    }
}
