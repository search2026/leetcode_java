package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementInAnArrayTests {

    @Test
    public void test1() {
        KthLargestElementInAnArray.Solution sol = new KthLargestElementInAnArray().new Solution();
        assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void test2() {
        KthLargestElementInAnArray.Solution_2 sol = new KthLargestElementInAnArray().new Solution_2();
        assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void test3() {
        KthLargestElementInAnArray.Solution_3 sol = new KthLargestElementInAnArray().new Solution_3();
        assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void test4() {
        KthLargestElementInAnArray.Solution_4 sol = new KthLargestElementInAnArray().new Solution_4();
        assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

}
