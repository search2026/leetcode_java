package com.search2026.leetcode.problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DesignBoundedBlockingQueue {

    /*
        Design Bounded Blocking Queue - ReentrantLock lock
        Leetcode #1188
        https://github.com/search2026/leetcode_java/blob/master/problems1101_1200/resources/DesignBoundedBlockingQueue.md
        Difficulty: Medium
     */
    class BoundedBlockingQueue {
        private ReentrantLock lock = new ReentrantLock();
        private Condition full = lock.newCondition();
        private Condition empty = lock.newCondition();
        private int [] que;
        private int head = 0;
        private int tail = 0;
        private int size = 0;

        public BoundedBlockingQueue(int capacity) {
            que = new int[capacity];
        }

        public void enqueue(int element) throws InterruptedException {
            lock.lock();
            try{
                while(size == que.length){
                    full.await();
                }

                que[tail++] = element;
                tail %= que.length;
                size++;
                empty.signal();
            }finally{
                lock.unlock();
            }
        }

        public int dequeue() throws InterruptedException {
            lock.lock();
            try{
                while(size == 0){
                    empty.await();
                }

                int res = que[head++];
                head %= que.length;
                size--;
                full.signal();
                return res;
            }finally{
                lock.unlock();
            }
        }

        public int size() {
            lock.lock();
            try{
                return this.size;
            }finally{
                lock.unlock();
            }
        }
    }

}
