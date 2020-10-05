package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementQueueUsingStacksTests {

    @Test
    public void test1() {
        ImplementQueueUsingStacks.MyQueue myQueue = new ImplementQueueUsingStacks().new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        int res = myQueue.peek(); // return 1
        assertEquals(1, res);
        myQueue.pop(); // return 1, queue is [2]
        assertFalse(myQueue.empty()); // return false
    }

}
