package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexicographicalNumbersTests {

    @Test
    public void testSolution() {
        LexicographicalNumbers.Solution sol = new LexicographicalNumbers().new Solution();
        List<Integer> res = sol.lexicalOrder(13);
        assertEquals(13, res.size());
        assertEquals(1, (int) res.get(0));
        assertEquals(10, (int) res.get(1));
        assertEquals(11, (int) res.get(2));
        assertEquals(12, (int) res.get(3));
        assertEquals(13, (int) res.get(4));
        assertEquals(2, (int) res.get(5));
        assertEquals(3, (int) res.get(6));
        assertEquals(4, (int) res.get(7));
        assertEquals(5, (int) res.get(8));
        assertEquals(6, (int) res.get(9));
        assertEquals(7, (int) res.get(10));
        assertEquals(8, (int) res.get(11));
        assertEquals(9, (int) res.get(12));
    }

}
