package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleNumberTests {

    @Test
    public void test1() {
        SingleNumber.Solution sol = new SingleNumber().new Solution();

        int[] test1 = {1, 2, -3, -3, 2};
        assertEquals(1, sol.singleNumber(test1));

        int[] test2 = {1, 2, -3, -3, 2, 1, 9};
        assertEquals(9, sol.singleNumber(test2));

        int[] test3 = {9, 1, -8, 2, -3, -3, 2, 1, 9};
        assertEquals(-8, sol.singleNumber(test3));
    }

    @Test
    public void test2() {
        SingleNumber.Solution_2 sol = new SingleNumber().new Solution_2();

        int[] test1 = {1, 2, -3, -3, 2};
        assertEquals(1, sol.singleNumber(test1));

        int[] test2 = {1, 2, -3, -3, 2, 1, 9};
        assertEquals(9, sol.singleNumber(test2));

        int[] test3 = {9, 1, -8, 2, -3, -3, 2, 1, 9};
        assertEquals(-8, sol.singleNumber(test3));
    }

    @Test
    public void test3() {
        SingleNumber.Solution_3 sol = new SingleNumber().new Solution_3();

        int[] test1 = {1, 2, -3, -3, -3, 2, 2};
        assertEquals(1, sol.singleNumber(test1));

        int[] test2 = {1, 1, 2, -3, -3, -3, 2, 2, 1, 9};
        assertEquals(9, sol.singleNumber(test2));

        int[] test3 = {9, 1, 1, -8, 2, -3, 9, -3, -3, 2, 2, 1, 9};
        assertEquals(-8, sol.singleNumber(test3));
    }

    @Test
    public void test4() {
        SingleNumber.Solution_4 sol = new SingleNumber().new Solution_4();

        int[] test1 = {1, 2, -3, -3, -3, 2, 2};
        assertEquals(1, sol.singleNumber(test1));

        int[] test2 = {1, 1, 2, -3, -3, -3, 2, 2, 1, 9};
        assertEquals(9, sol.singleNumber(test2));

        int[] test3 = {9, 1, 1, -8, 2, -3, 9, -3, -3, 2, 2, 1, 9};
        assertEquals(-8, sol.singleNumber(test3));
    }

    @Test
    public void test5() {
        SingleNumber.Solution_5 sol = new SingleNumber().new Solution_5();

        int[] test1 = {1, 2, -3, -3, -3, 2, 2};
        assertEquals(1, sol.singleNumber(test1));

        int[] test2 = {1, 1, 2, -3, -3, -3, 2, 2, 1, 9};
        assertEquals(9, sol.singleNumber(test2));

        int[] test3 = {9, 1, 1, -8, 2, -3, 9, -3, -3, 2, 2, 1, 9};
        assertEquals(-8, sol.singleNumber(test3));
    }

    @Test
    public void test6() {
        SingleNumber.Solution_6 sol = new SingleNumber().new Solution_6();

        int[] test1 = {1, 2, -3, -3, -3, 2, 2};
        assertEquals(1, sol.singleNumber(test1));

        int[] test2 = {1, 1, 2, -3, -3, -3, 2, 2, 1, 9};
        assertEquals(9, sol.singleNumber(test2));

        int[] test3 = {9, 1, 1, -8, 2, -3, 9, -3, -3, 2, 2, 1, 9};
        assertEquals(-8, sol.singleNumber(test3));
    }

    @Test
    public void test7() {
        SingleNumber.Solution_7 sol = new SingleNumber().new Solution_7();

        int[] test1 = {1, 2, 1, 3, 2, 5};
        int[] result = sol.singleNumber(test1);
        assertEquals(2, result.length);
        assertEquals(5, result[0]);
        assertEquals(3, result[1]);
    }

    @Test
    public void test8() {
        SingleNumber.Solution_8 sol = new SingleNumber().new Solution_8();

        int[] test1 = {1, 2, 1, 3, 2, 5};
        int[] result = sol.singleNumber(test1);
        assertEquals(2, result.length);
        assertEquals(5, result[0]);
        assertEquals(3, result[1]);
    }

    @Test
    public void test9() {
        SingleNumber.Solution_9 sol = new SingleNumber().new Solution_9();

        int[] test1 = {1, 2, -3, -3, -3, 2, 2};
        assertEquals(1, sol.singleNumber(test1, 3, 1));

        int[] test2 = {1, 2, -3, -3, 2, 1, 9};
        assertEquals(9, sol.singleNumber(test2, 2, 1));

        int[] test3 = {9, 1, 1, -8, 2, -3, 9, -3, -3, 2, 2, -8, 1, 9};
        assertEquals(-8, sol.singleNumber(test3, 3, 2));
    }

}
