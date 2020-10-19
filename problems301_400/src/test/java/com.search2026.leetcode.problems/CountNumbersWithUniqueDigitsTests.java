package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountNumbersWithUniqueDigitsTests {

    @Test
    public void test1() {
        CountNumbersWithUniqueDigits.Solution sol = new CountNumbersWithUniqueDigits().new Solution();
        assertEquals(1, sol.countNumbersWithUniqueDigits(0));
        assertEquals(10, sol.countNumbersWithUniqueDigits(1));
        assertEquals(91, sol.countNumbersWithUniqueDigits(2));
        assertEquals(739, sol.countNumbersWithUniqueDigits(3));
        assertEquals(5275, sol.countNumbersWithUniqueDigits(4));
        assertEquals(32491, sol.countNumbersWithUniqueDigits(5));
        assertEquals(168571, sol.countNumbersWithUniqueDigits(6));
        assertEquals(712891, sol.countNumbersWithUniqueDigits(7));
        assertEquals(2345851, sol.countNumbersWithUniqueDigits(8));
        assertEquals(5611771, sol.countNumbersWithUniqueDigits(9));
        assertEquals(8877691, sol.countNumbersWithUniqueDigits(10));
        assertEquals(8877691, sol.countNumbersWithUniqueDigits(11));

    }

    @Test
    public void test2() {
        CountNumbersWithUniqueDigits.Solution_2 sol = new CountNumbersWithUniqueDigits().new Solution_2();
        assertEquals(1, sol.countNumbersWithUniqueDigits(0));
        assertEquals(10, sol.countNumbersWithUniqueDigits(1));
        assertEquals(91, sol.countNumbersWithUniqueDigits(2));
        assertEquals(739, sol.countNumbersWithUniqueDigits(3));
        assertEquals(5275, sol.countNumbersWithUniqueDigits(4));
        assertEquals(32491, sol.countNumbersWithUniqueDigits(5));
        assertEquals(168571, sol.countNumbersWithUniqueDigits(6));
        assertEquals(712891, sol.countNumbersWithUniqueDigits(7));
        assertEquals(2345851, sol.countNumbersWithUniqueDigits(8));
        assertEquals(5611771, sol.countNumbersWithUniqueDigits(9));
        assertEquals(8877691, sol.countNumbersWithUniqueDigits(10));
        assertEquals(8877691, sol.countNumbersWithUniqueDigits(11));
    }

    @Test
    public void test3() {
        CountNumbersWithUniqueDigits.Solution_3 sol = new CountNumbersWithUniqueDigits().new Solution_3();
        assertEquals(1, sol.countNumbersWithUniqueDigits(0));
        assertEquals(10, sol.countNumbersWithUniqueDigits(1));
        assertEquals(91, sol.countNumbersWithUniqueDigits(2));
        assertEquals(739, sol.countNumbersWithUniqueDigits(3));
        assertEquals(5275, sol.countNumbersWithUniqueDigits(4));
        assertEquals(32491, sol.countNumbersWithUniqueDigits(5));
        assertEquals(168571, sol.countNumbersWithUniqueDigits(6));
        assertEquals(712891, sol.countNumbersWithUniqueDigits(7));
        assertEquals(2345851, sol.countNumbersWithUniqueDigits(8));
        assertEquals(5611771, sol.countNumbersWithUniqueDigits(9));
        assertEquals(8877691, sol.countNumbersWithUniqueDigits(10));
        assertEquals(8877691, sol.countNumbersWithUniqueDigits(11));
    }

}
