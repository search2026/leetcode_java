package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ZigzagIteratorTests {

    @Test
    public void testSolution() {
        List<Integer> v1 = new LinkedList<>();
        v1.add(1);
        v1.add(2);
        List<Integer> v2 = new LinkedList<>();
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);
        ZigzagIterator it = new ZigzagIterator(v1, v2);
        List<Integer> res = new LinkedList<>();
        while(it.hasNext()) {
            res.add(it.next());
        }
        assertEquals(6, res.size());
        assertEquals(1, res.get(0));
        assertEquals(3, res.get(1));
        assertEquals(2, res.get(2));
        assertEquals(4, res.get(3));
        assertEquals(5, res.get(4));
        assertEquals(6, res.get(5));
    }

}
