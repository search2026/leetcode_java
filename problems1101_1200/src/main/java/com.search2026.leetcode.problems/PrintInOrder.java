package com.search2026.leetcode.problems;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PrintInOrder {

    /*
        Print in Order - Using Semaphore
        Leetcode #1114
        https://leetcode.com/problems/print-in-order/
        Difficulty: Easy
     */
    class Foo {
        /*
        "Semaphore is a bowl of marbles" - Professor Stark

        Semaphore is a bowl of marbles (or locks in this case). If you need a marble, and there are none, you wait. You
        wait until there is one marble and then you take it. If you release(), you will add one marble to the bowl
        (from thin air). If you release(100), you will add 100 marbles to the bowl (from thin air).
        The thread calling third() will wait until the end of second() when it releases a '3' marble. The second() will
        wait until the end of first() when it releases a '2' marble. Since first() never acquires anything, it will
        never wait. There is a forced wait ordering.
        With semaphores, you can start out with 1 marble or 0 marbles or 100 marbles. A thread can take marbles (up
        until it's empty) or put many marbles (out of thin air) at a time.

         */ Semaphore run2, run3;

        public Foo() {
            run2 = new Semaphore(0);
            run3 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            run2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            run2.acquire();
            printSecond.run();
            run3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            run3.acquire();
            printThird.run();
        }
    }

    /*
        Print in Order - Using Concurrent CountDownLatch
        Leetcode #1114
        https://leetcode.com/problems/print-in-order/
        Difficulty: Easy
     */
    class Foo_2 {
        private final CountDownLatch l2;
        private final CountDownLatch l3;

        public Foo_2() {
            l2 = new CountDownLatch(1);
            l3 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            l2.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            l2.await();
            printSecond.run();
            l3.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            l3.await();
            printThird.run();
        }
    }


    /*
        Print in Order - Using synchronized methods
        Leetcode #1114
        https://leetcode.com/problems/print-in-order/
        Difficulty: Easy
     */
    class Foo_3 {
        int count = 0;

        public Foo_3() {
        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            count++;
            this.notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while(count != 1){
                this.wait();
            }
            printSecond.run();
            count++;
            this.notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while(count != 2){
                this.wait();
            }
            printThird.run();
            count++;
        }
    }

}
