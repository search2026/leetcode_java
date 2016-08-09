package insert_delete_getrandom_o1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class InsertDeleteGetRandomO1 {
  /*
      Insert Delete GetRandom O(1)
      Leetcode #380
      https://leetcode.com/problems/insert-delete-getrandom-o1/
      Difficulty: Medium
   */
  public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random rand = new java.util.Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
      nums = new ArrayList<Integer>();
      locs = new HashMap<Integer, Integer>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
      boolean contain = locs.containsKey(val);
      if (contain) return false;
      locs.put(val, nums.size());
      nums.add(val);
      return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
      boolean contain = locs.containsKey(val);
      if (!contain) return false;
      int loc = locs.get(val);
      if (loc < nums.size() - 1) { // not the last one than swap the last one with this val
        int lastone = nums.get(nums.size() - 1);
        nums.set(loc, lastone);
        locs.put(lastone, loc);
      }
      locs.remove(val);
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
  }
}

