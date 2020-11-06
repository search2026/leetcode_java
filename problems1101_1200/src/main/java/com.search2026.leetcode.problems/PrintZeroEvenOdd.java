package com.search2026.leetcode.problems;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {

    /*
        Print Zero Even Odd - Synchronized Lock
        Leetcode #1116
        https://leetcode.com/problems/print-zero-even-odd/
        Difficulty: Medium
     */
    class ZeroEvenOdd {
        private int n;
        private boolean iszero = true;
        private boolean isodd = true;
        private boolean iseven = false;

        private Object lock = new Object();

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (!iszero) {
                        lock.wait();
                    }
                    printNumber.accept(0);
                    iszero = false;
                    lock.notifyAll();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                synchronized (lock) {
                    while (iszero || !iseven) {
                        lock.wait();
                    }
                    printNumber.accept(i);
                    iseven = false;
                    isodd = true;
                    iszero = true;
                    lock.notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                synchronized (lock) {
                    while (iszero || !isodd) {
                        lock.wait();
                    }
                    printNumber.accept(i);
                    iseven = true;
                    isodd = false;
                    iszero = true;
                    lock.notifyAll();
                }
            }
        }
    }

    /*
        Print Zero Even Odd - Semaphore
        Leetcode #1116
        https://leetcode.com/problems/print-zero-even-odd/
        Difficulty: Medium
     */
    class ZeroEvenOdd_2 {
        int n;

        Semaphore semaphoreEven, semaphoreOdd, semaphoreZero;

        public ZeroEvenOdd_2(int n) {
            this.n = n;

            semaphoreZero = new Semaphore(1);
            semaphoreEven = new Semaphore(0);
            semaphoreOdd = new Semaphore(0);
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            int numTimes = this.n;
            boolean printOdd = true;

            for(int i = 0; i < numTimes; i++){
                semaphoreZero.acquire();

                printNumber.accept(0);

                //print the next number
                if(printOdd)
                    semaphoreOdd.release();
                else
                    semaphoreEven.release();

                printOdd = !printOdd;   //flip it!
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            int numTimes = this.n / 2;

            int nextEvenNum = 2;
            for(int i = 0; i < numTimes; i++){
                semaphoreEven.acquire();

                printNumber.accept(nextEvenNum);
                nextEvenNum += 2;

                semaphoreZero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            int numTimes = (int)Math.ceil((double)this.n / 2);

            int nextOdd = 1;
            for(int i = 0; i < numTimes; i++){
                semaphoreOdd.acquire();

                printNumber.accept(nextOdd);
                nextOdd += 2;

                semaphoreZero.release();
            }
        }
    }

}
