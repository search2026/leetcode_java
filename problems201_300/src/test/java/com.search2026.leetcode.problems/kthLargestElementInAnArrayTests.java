package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class kthLargestElementInAnArrayTests {

    @Test
    public void test1() {
        kthLargestElementInAnArray.Solution sol = new kthLargestElementInAnArray().new Solution();
        assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void test2() {
        kthLargestElementInAnArray.Solution_2 sol = new kthLargestElementInAnArray().new Solution_2();
        assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void test3() {
        kthLargestElementInAnArray.Solution_3 sol = new kthLargestElementInAnArray().new Solution_3();
        assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void test4() {
        kthLargestElementInAnArray.Solution_4 sol = new kthLargestElementInAnArray().new Solution_4();
        assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

}
