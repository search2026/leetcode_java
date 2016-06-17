package sort_transformed_array;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class SortTransformedArray {
  /*
      Sort Transformed Array
      Leetcode #360
      https://leetcode.com/discuss/oj/sort-transformed-array
      Difficulty: Medium
   */
  public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
      PriorityQueue<Integer> q = new PriorityQueue<Integer>();
      for (int i = 0; i < nums.length; i++) {
        int temp = value(nums[i], a, b, c);
        q.offer(temp);
      }
      int[] rslt = new int[nums.length];
      for (int i = 0; i < nums.length; i++) rslt[i] = q.poll();

      return rslt;
    }

    private int value(int x, int a, int b, int c) {
      return a * x * x + b * x + c;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new SortTransformedArray().new Solution();
      assertEquals(1, 1);
    }
  }
}

