package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PeekingIteratorTests {

    @Test
    public void testSolution() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator iter = new PeekingIterator(list.iterator());
        assertTrue(iter.hasNext());
        assertEquals(1, (int) iter.next());
        assertEquals(2, (int) iter.peek());
        assertEquals(2, (int) iter.next());
        assertEquals(3, (int) iter.peek());
        assertEquals(3, (int) iter.next());
        assertFalse(iter.hasNext());
    }

}
