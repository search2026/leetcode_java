package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheTests {

    @Test
    public void testSolution() {
        LRUCache.Solution lru = new LRUCache().new Solution(5);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.set(4, 4);
        assertEquals(lru.get(4), 4);
        assertEquals(lru.get(6), -1);
        lru.set(5, 5);
        lru.set(6, 6);
        assertEquals(lru.get(6), 6);
        assertEquals(lru.get(1), -1);
    }

    @Test
    public void testSolution2() {
        LRUCache.Solution_2 lru = new LRUCache().new Solution_2(5);
        lru.set(4, 4);
        lru.set(3, 3);
        lru.set(2, 2);
        lru.set(1, 1);
        assertEquals(lru.get(4), 4);
        assertEquals(lru.get(6), -1);
        lru.set(6, 6);
        lru.set(5, 5);
        assertEquals(lru.get(6), 6);
        assertEquals(lru.get(3), -1);
    }

}
