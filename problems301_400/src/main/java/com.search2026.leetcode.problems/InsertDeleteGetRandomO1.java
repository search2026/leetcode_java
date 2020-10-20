package com.search2026.leetcode.problems;

import java.util.*;

public class InsertDeleteGetRandomO1 {

    /*
        Insert Delete GetRandom O(1)
        Leetcode #380
        https://leetcode.com/problems/insert-delete-getrandom-o1/
        Difficulty: Medium
     */
    public class RandomizedSet {
        List<Integer> nums;
        Map<Integer, Integer> val2PosMap;
        Random rand;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            nums = new ArrayList<Integer>();
            val2PosMap = new HashMap<Integer, Integer>();
            rand = new Random();
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
        Random rand;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            nums = new ArrayList<>();
            val2PosMap = new HashMap<>();
            rand = new Random();
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

}
