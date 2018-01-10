package insert_delete_getrandom_o1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class InsertDeleteGetRandomO1 {
    /*
        Insert Delete GetRandom O(1)
        Leetcode #380
        https://leetcode.com/problems/insert-delete-getrandom-o1/
        Difficulty: Medium
     */
    public class RandomizedSet {
        ArrayList<Integer> nums;
        HashMap<Integer, Integer> val2PosMap;
        java.util.Random rand;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            nums = new ArrayList<Integer>();
            val2PosMap = new HashMap<Integer, Integer>();
            rand = new java.util.Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean hasVal = val2PosMap.containsKey(val);
            if (hasVal) return false;
            val2PosMap.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            boolean hasVal = val2PosMap.containsKey(val);
            if (!hasVal) return false;
            int pos = val2PosMap.get(val);
            if (pos < nums.size() - 1) {
                int tailVal = nums.get(nums.size() - 1);
                nums.set(pos, tailVal);
                val2PosMap.put(tailVal, pos);
            }
            val2PosMap.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

    /*
        Insert Delete GetRandom O(1) - Duplicates allowed
        Leetcode #381
        https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
        Difficulty: Medium
     */
    public class RandomizedCollection {
        ArrayList<Integer> nums;
        HashMap<Integer, Set<Integer>> val2PosMap;
        java.util.Random rand;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            nums = new ArrayList<>();
            val2PosMap = new HashMap<>();
            rand = new java.util.Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean contain = val2PosMap.containsKey(val);
            if (!contain) val2PosMap.put(val, new HashSet<>());
            val2PosMap.get(val).add(nums.size());
            nums.add(val);
            return !contain;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            boolean contain = val2PosMap.containsKey(val);
            if (!contain) return false;
            int loc = val2PosMap.get(val).iterator().next();
            if (loc < nums.size() - 1) {
                int lastone = nums.get(nums.size() - 1);
                nums.set(loc, lastone);
                val2PosMap.get(lastone).remove(nums.size() - 1);
                val2PosMap.get(lastone).add(loc);
            }
            nums.remove(nums.size() - 1);
            val2PosMap.get(val).remove(loc);
            if (val2PosMap.get(val).isEmpty()) val2PosMap.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            // Init an empty set.
            RandomizedSet randomSet = new InsertDeleteGetRandomO1().new RandomizedSet();

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
        public void test2() {
            // Init an empty collection.
            RandomizedCollection collection = new InsertDeleteGetRandomO1().new RandomizedCollection();

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
}

