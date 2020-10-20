package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxStackTests {

    @Test
    public void testSolution() {
        MaxStack.Solution sol = new MaxStack().new Solution();
        sol.push(5);
        sol.push(1);
        sol.push(5);
        assertEquals(5, sol.top());
        assertEquals(5, sol.popMax());
        assertEquals(1, sol.top());
        assertEquals(5, sol.peekMax());
        assertEquals(1, sol.pop());
        assertEquals(5, sol.top());
    }

    @Test
    public void testSolution2() {
        MaxStack.Solution_2 sol = new MaxStack().new Solution_2();
        sol.push(5);
        sol.push(1);
        sol.push(5);
        assertEquals(5, sol.top());
        assertEquals(5, sol.popMax());
        assertEquals(1, sol.top());
        assertEquals(5, sol.peekMax());
        assertEquals(1, sol.pop());
        assertEquals(5, sol.top());
    }

    @Test
    public void testSolution3() {
        MaxStack.Solution_3 sol = new MaxStack().new Solution_3();
        sol.push(5);
        sol.push(1);
        sol.push(5);
        assertEquals(5, sol.top());
        assertEquals(5, sol.popMax());
        assertEquals(1, sol.top());
        assertEquals(5, sol.peekMax());
        assertEquals(1, sol.pop());
        assertEquals(5, sol.top());
    }

}
