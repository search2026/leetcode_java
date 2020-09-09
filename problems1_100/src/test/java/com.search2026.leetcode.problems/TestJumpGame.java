package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestJumpGame {

    @Test
    public void test1() {
        JumpGame.Solution sol = new JumpGame().new Solution();
        assertTrue(sol.canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(sol.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void test2() {
        JumpGame.Solution_2 sol2 = new JumpGame().new Solution_2();
        assertTrue(sol2.canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(sol2.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void test3() {
        JumpGame.Solution_3 sol = new JumpGame().new Solution_3();
        assertEquals(2, sol.jump(new int[]{2, 3, 1, 1, 4}));
    }

}
