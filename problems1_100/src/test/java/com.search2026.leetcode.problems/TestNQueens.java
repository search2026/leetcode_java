package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestNQueens {

    @Test
    public void test1() {
        NQueens.Solution sol = new NQueens().new Solution();
        List<List<String>> res = sol.solveNQueens(4);
        assertEquals(2, res.size());
    }


    @Test
    public void test2() {
        NQueens.Solution_2 sol = new NQueens().new Solution_2();
        assertEquals(1, sol.totalNQueens(1));
        assertEquals(92, sol.totalNQueens(8));
    }


    @Test
    public void test3() {
        NQueens.Solution_3 sol = new NQueens().new Solution_3();
        assertEquals(1, sol.totalNQueens(1));
        assertEquals(92, sol.totalNQueens(8));
    }

}
