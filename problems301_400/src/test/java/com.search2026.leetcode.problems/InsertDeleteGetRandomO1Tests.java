package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InsertDeleteGetRandomO1Tests {

    @Test
    public void testSolution() {
        // Init an empty set.
        InsertDeleteGetRandomO1.RandomizedSet randomSet = new InsertDeleteGetRandomO1().new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        assertTrue(randomSet.insert(1));

        // Returns false as 2 does not exist in the set.
        assertFalse(randomSet.remove(2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        assertTrue(randomSet.insert(2));

        // getRandom should return either 1 or 2 randomly.
        assertNotEquals(0, randomSet.getRandom());
        assertNotEquals(3, randomSet.getRandom());

        // Removes 1 from the set, returns true. Set now contains [2].
        assertTrue(randomSet.remove(1));

        // 2 was already in the set, so return false.
        assertFalse(randomSet.insert(2));

        // Since 1 is the only number in the set, getRandom always return 2.
        assertEquals(2, randomSet.getRandom());
    }

    @Test
    public void testSolution2() {
        // Init an empty collection.
        InsertDeleteGetRandomO1.RandomizedCollection collection = new InsertDeleteGetRandomO1().new RandomizedCollection();

        // Inserts 1 to the collection. Returns true as the collection did not contain 1.
        assertTrue(collection.insert(1));

        // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
        collection.insert(1);

        // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
        assertTrue(collection.insert(2));

        // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
        assertNotEquals(0, collection.getRandom());
        assertNotEquals(3, collection.getRandom());

        // Removes 1 from the collection, returns true. Collection now contains [1,2].
        assertTrue(collection.remove(1));

        // getRandom should return 1 and 2 both equally likely.
        assertNotEquals(0, collection.getRandom());
        assertNotEquals(3, collection.getRandom());
    }

}
