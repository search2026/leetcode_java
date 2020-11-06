package com.search2026.leetcode.problems;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternately {

    /*
        Print FooBar Alternately - Synchronized
        Leetcode #1115
        https://leetcode.com/problems/print-foobar-alternately/
        Difficulty: Medium
     */
    public class FooBar {

        private int n;
        //flag 0->foo to be print  1->foo has been printed
        private int flag = 0;


        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (flag == 1) {
                        this.wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = 1;
                    this.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (flag == 0) {
                        this.wait();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    flag = 0;
                    this.notifyAll();
                }
            }
        }
    }

    /*
        Print FooBar Alternately - Semaphore
        Leetcode #1115
        https://leetcode.com/problems/print-foobar-alternately/
        Difficulty: Medium
     */
    class FooBar_2 {
        private int n;
        Semaphore s = new Semaphore(0);
        Semaphore s2 = new Semaphore(1);

        public FooBar_2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                s2.acquire();

                printFoo.run();
                s.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                s.acquire();

                printBar.run();
                s2.release();
            }
        }
    }

}
