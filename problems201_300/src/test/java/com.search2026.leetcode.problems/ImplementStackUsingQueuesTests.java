package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementStackUsingQueuesTests {

    @Test
    public void testSolution() {
        ImplementStackUsingQueues.MyStack stack = new ImplementStackUsingQueues().new MyStack();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.top());   // returns 2
//        assertEquals(2, stack.pop());   // returns 2
        assertFalse(stack.empty()); // returns false
    }

}
