package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMergeSortedArray {

    @Test
    public void test1() {
        MergeSortedArray.Solution sol = new MergeSortedArray().new Solution();
        int[] array1 = {1, 3, 5, 0, 0, 0, 0};
        int[] array2 = {2, 4};
        sol.merge(array1, 3, array2, 2);
        assertEquals(1, array1[0]);
        assertEquals(2, array1[1]);
        assertEquals(3, array1[2]);
        assertEquals(4, array1[3]);
        assertEquals(5, array1[4]);
        assertEquals(0, array1[5]);
    }

    @Test
    public void test2() {
        MergeSortedArray.Solution_2 sol = new MergeSortedArray().new Solution_2();
        int[] array1 = {1, 3, 5, 0, 0, 0, 0};
        int[] array2 = {2, 4};
        sol.merge(array1, 3, array2, 2);
        assertEquals(1, array1[0]);
        assertEquals(2, array1[1]);
        assertEquals(3, array1[2]);
        assertEquals(4, array1[3]);
        assertEquals(5, array1[4]);
        assertEquals(0, array1[5]);
    }

}
