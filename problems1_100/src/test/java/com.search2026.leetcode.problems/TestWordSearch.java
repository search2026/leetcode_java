package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestWordSearch {

    @Test
    public void test1() {
        WordSearch.Solution sol = new WordSearch().new Solution();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(sol.exist(board, "ABCCED"));
        assertTrue(sol.exist(board, "SEE"));
        assertFalse(sol.exist(board, "ABCB"));
    }

    @Test
    public void test2() {
        WordSearch.Solution_2 sol = new WordSearch().new Solution_2();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(sol.search(board, "ABCCED"));
        assertTrue(sol.search(board, "SEE"));
        // assertFalse(sol.search(board, "ABCB"));
    }

    @Test
    public void test3() {
        WordSearch.Solution_3 sol = new WordSearch().new Solution_3();
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> res = sol.findWords(board, words);
        assertEquals(2, res.size());
        assertTrue(res.contains("oath"));
        assertTrue(res.contains("eat"));
        assertFalse(res.contains("pea"));
        assertFalse(res.contains("rain"));
    }

    @Test
    public void test4() {
        WordSearch.Solution_4 sol = new WordSearch().new Solution_4();
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> res = sol.findWords(board, words);
        assertEquals(2, res.size());
        assertTrue(res.contains("oath"));
        assertTrue(res.contains("eat"));
        assertFalse(res.contains("pea"));
        assertFalse(res.contains("rain"));
    }

}
