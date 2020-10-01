package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CourseScheduleTests {

    @Test
    public void testSolution() {
        CourseSchedule.Solution sol = new CourseSchedule().new Solution();
        int n = 2;
        int[][] pre = new int[][]{
                new int[]{1, 0}
        };
        assertTrue(sol.canFinish(n, pre));

        pre = new int[][]{
                new int[]{1, 0},
                new int[]{0, 1}
        };
        assertFalse(sol.canFinish(n, pre));
    }

    @Test
    public void testSolution2() {
        CourseSchedule.Solution_2 sol = new CourseSchedule().new Solution_2();
        int n = 2;
        int[][] pre = new int[][]{
                new int[]{1, 0}
        };
        assertTrue(sol.canFinish(n, pre));

        pre = new int[][]{
                new int[]{1, 0},
                new int[]{0, 1}
        };
        assertFalse(sol.canFinish(n, pre));
    }

    @Test
    public void testSolution3() {
        CourseSchedule.Solution_3 sol = new CourseSchedule().new Solution_3();
        assertArrayEquals(new int[]{0, 1}, sol.findOrder(2, new int[][]{{1, 0}}));
        assertArrayEquals(new int[]{0, 1, 2, 3}, sol.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
    }

}
