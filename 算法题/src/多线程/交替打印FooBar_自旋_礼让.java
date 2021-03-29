package 多线程;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 彭一鸣  1115. 交替打印FooBar    https://leetcode-cn.com/problems/print-foobar-alternately/
 * @since 2021/3/29 13:39
 */
public class 交替打印FooBar_自旋_礼让 {
    private int n;

    public 交替打印FooBar_自旋_礼让(int n) {
        this.n = n;
    }

    volatile boolean permitFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if(permitFoo) {
                printFoo.run();
                i++;
                permitFoo = false;
            }else{
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if(!permitFoo) {
                printBar.run();
                i++;
                permitFoo = true;
            }else{
                Thread.yield();
            }
        }
    }
}
