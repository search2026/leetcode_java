package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSpiralMatrix {

    @Test
    public void test1() {
        SpiralMatrix.Solution sol = new SpiralMatrix().new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> printed = sol.spiralOrder(matrix);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(6);
        expected.add(9);
        expected.add(8);
        expected.add(7);
        expected.add(4);
        expected.add(5);
        assertEquals(printed, expected);
    }

    @Test
    public void test2() {
        SpiralMatrix.Solution_2 sol = new SpiralMatrix().new Solution_2();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> printed = sol.spiralOrder(matrix);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(6);
        expected.add(9);
        expected.add(8);
        expected.add(7);
        expected.add(4);
        expected.add(5);
        assertEquals(printed, expected);
        // [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
        // [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
    }

    @Test
    public void test3() {
        SpiralMatrix.Solution_3 sol = new SpiralMatrix().new Solution_3();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> printed = sol.spiralOrder(matrix);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(6);
        expected.add(9);
        expected.add(8);
        expected.add(7);
        expected.add(4);
        expected.add(5);
        assertEquals(printed, expected);
        // [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
        // [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
    }

    @Test
    public void test4() {
        SpiralMatrix.Solution_4 sol = new SpiralMatrix().new Solution_4();
        int[][] matrix = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        int[][] printed = sol.generateMatrix(3);
        assertEquals(3, printed.length);
        assertEquals(3, printed[0].length);
        for (int i = 0; i < 3; i++) {
            assertArrayEquals(matrix[i], printed[i]);
        }
    }

    @Test
    public void test5() {
        SpiralMatrix.Solution_5 sol = new SpiralMatrix().new Solution_5();
        int[][] matrix = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        int[][] printed = sol.generateMatrix(3);
        assertEquals(3, printed.length);
        assertEquals(3, printed[0].length);
        for (int i = 0; i < 3; i++) {
            assertArrayEquals(matrix[i], printed[i]);
        }
    }

}
