package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextJustificationTests {

    @Test
    public void testSolution() {
        TextJustification.Solution sol = new TextJustification().new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = sol.fullJustify(words, 16);
        assertEquals(3, res.size());
        assertEquals(res.get(0), "This    is    an");
        assertEquals(res.get(1), "example  of text");
        assertEquals(res.get(2), "justification.  ");
    }

    @Test
    public void testSolution2() {
        TextJustification.Solution_2 sol = new TextJustification().new Solution_2();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = sol.fullJustify(words, 16);
        assertEquals(3, res.size());
        assertEquals(res.get(0), "This    is    an");
        assertEquals(res.get(1), "example  of text");
        assertEquals(res.get(2), "justification.  ");
    }

}
