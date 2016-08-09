package insert_delete_getrandom_o1_duplicates_allowed;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class InsertDeleteGetRandomO1Duplicatesallowed {
  /*
      Insert Delete GetRandom O(1) - Duplicates allowed
      Leetcode #381
      https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
      Difficulty: Medium
   */
  public class RandomizedCollection {
    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> locs;
    java.util.Random rand = new java.util.Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
      nums = new ArrayList<Integer>();
      locs = new HashMap<Integer, Set<Integer>>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
      boolean contain = locs.containsKey(val);
      if (!contain) locs.put(val, new HashSet<Integer>());
      locs.get(val).add(nums.size());
      nums.add(val);
      return !contain;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
      boolean contain = locs.containsKey(val);
      if (!contain) return false;
      int loc = locs.get(val).iterator().next();
      if (loc < nums.size() - 1) {
        int lastone = nums.get(nums.size() - 1);
        nums.set(loc, lastone);
        locs.get(lastone).remove(nums.size() - 1);
        locs.get(lastone).add(loc);
      }
      nums.remove(nums.size() - 1);
      locs.get(val).remove(loc);
      if (locs.get(val).isEmpty()) locs.remove(val);
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
      // Init an empty collection.
      RandomizedCollection collection = new InsertDeleteGetRandomO1Duplicatesallowed().new RandomizedCollection();

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

