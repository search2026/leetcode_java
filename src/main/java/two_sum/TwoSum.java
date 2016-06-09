package two_sum;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TwoSum {
  /*
      Two Sum - HashMap
      Leetcode #1
      https://leetcode.com/problems/two-sum/
      Difficulty: Medium
   */
  public class Solution {
    public int[] twoSum(int[] nums, int target) {
      if (nums == null || nums.length < 2) return null;

      int n = nums.length;
      Map<Integer, Integer> map = new HashMap<>();
      map.put(nums[0], 1);
      for (int i=1; i< n; i++) {
        int diff = target - nums[i];
        if (map.containsKey(diff)) {
          return new int[]{map.get(diff), i+1};
        } else {
          map.put(nums[i], i+1);
        }
      }

      return null;
    }
  }

  /*
      Two Sum II - Two Pointers
      Leetcode #167
      https://leetcode.com/discuss/oj/two-sum-ii-input-array-is-sorted
      http://www.cnblogs.com/ganganloveu/p/4198968.html
      Difficulty: Medium
   */
  public class Solution_2 {
    public int[] twoSum(int[] nums, int target) {
      if (nums == null || nums.length < 2) return null;

      int p1=0, p2=nums.length-1;

      while(p1<p2) {
        int sum = nums[p1] + nums[p2];
        if (sum == target) return new int[]{p1+1, p2+1};
        else if (sum < target) p1++;
        else p2--;
      }

      return null;
    }
  }

  /*
      Two Sum III Data Structure
      Leetcode #170
      https://leetcode.com/discuss/questions/oj/two-sum-iii-data-structure-design?sort=votes
      http://www.cnblogs.com/EdwardLiu/p/4252598.html
      Difficulty: Medium
   */
  public class TwoSumDS {
    private Map<Integer, Integer> map;

    TwoSumDS() {
      map = new HashMap<Integer, Integer>();
    }

    public void add(int number) {
      if (map.containsKey(number)) {
        map.put(number, map.get(number) + 1);
      } else {
        map.put(number, 1);
      }
    }

    public boolean find(int target) {
      if (map.size() < 2) return false;

      for (Integer key : map.keySet()){
        int diff = target - key;
        if (map.containsKey(diff)) {
          if (diff != key) return true;
          else if (map.get(key) > 1) return true;
        }
      }

      return false;
    }
  }


  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new TwoSum().new Solution();
      int[] test = {5, 75, 25};
      assertArrayEquals(new int[]{2, 3}, sol.twoSum(test, 100));
      assertArrayEquals(null, sol.twoSum(test, 99));
    }

    @Test
    public void test2() {
      Solution_2 sol = new TwoSum().new Solution_2();
      int[] test = {5, 25, 75};
      assertArrayEquals(new int[]{2, 3}, sol.twoSum(test, 100));
      assertArrayEquals(null, sol.twoSum(test, 99));
    }

    @Test
    public void test3() {
      TwoSumDS sol = new TwoSum().new TwoSumDS();
      sol.add(5);
      sol.add(75);
      sol.add(25);
      assertTrue(sol.find(100));
      assertFalse(sol.find(99));
    }
  }
}
