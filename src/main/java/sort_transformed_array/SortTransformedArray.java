package sort_transformed_array;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTransformedArray {
  /*
      Sort Transformed Array - Heap
      Leetcode #360
      https://leetcode.com/discuss/oj/sort-transformed-array
      http://www.cnblogs.com/grandyang/p/5595614.html
      Difficulty: Medium
   */
  public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
      if (nums == null || nums.length == 0) return new int[]{};
      PriorityQueue<Integer> q = new PriorityQueue<>();
      for (int i = 0; i < nums.length; i++) {
        int temp = a * nums[i] * nums[i] + b * nums[i] + c;
        q.offer(temp);
      }

      int[] rslt = new int[nums.length];
      for (int i = 0; i < nums.length; i++) rslt[i] = q.poll();

      return rslt;
    }
  }

  /*
      Sort Transformed Array - Two Pointers
      Leetcode #360
      https://leetcode.com/discuss/oj/sort-transformed-array
      http://www.cnblogs.com/grandyang/p/5595614.html
      Difficulty: Medium
   */
  public class Solution_2 {
    private int cal(int x, int a, int b, int c) {
      return a * x * x + b * x + c;
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
      if (nums == null || nums.length == 0) return new int[]{};
      int n = nums.length, p1 = 0, p2 = n - 1;
      int[] rslt = new int[n];
      int idx = a >= 0 ? n - 1 : 0;
      while (p1 <= p2) {
        if (a >= 0) {
          rslt[idx--] = cal(nums[p1], a, b, c) >= cal(nums[p2], a, b, c) ? cal(nums[p1++], a, b, c) : cal(nums[p2--], a, b, c);
        } else {
          rslt[idx++] = cal(nums[p1], a, b, c) >= cal(nums[p2], a, b, c) ? cal(nums[p2--], a, b, c) : cal(nums[p1++], a, b, c);
        }
      }
      return rslt;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new SortTransformedArray().new Solution();
      int[] testArr = {-4, -2, 2, 4};
      int[] rslt1 = {3, 9, 15, 33};
      int[] rslt2 = {-23, -5, 1, 7};
      assertArrayEquals(rslt1, sol.sortTransformedArray(testArr, 1, 3, 5));
      assertArrayEquals(rslt2, sol.sortTransformedArray(testArr, -1, 3, 5));
    }

    @Test
    public void test2() {
      Solution_2 sol = new SortTransformedArray().new Solution_2();
      int[] testArr = {-4, -2, 2, 4};
      int[] rslt1 = {3, 9, 15, 33};
      int[] rslt2 = {-23, -5, 1, 7};
      assertArrayEquals(rslt1, sol.sortTransformedArray(testArr, 1, 3, 5));
      assertArrayEquals(rslt2, sol.sortTransformedArray(testArr, -1, 3, 5));
    }
  }
}

