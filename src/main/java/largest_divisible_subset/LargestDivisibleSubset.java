package largest_divisible_subset;

import java.util.*;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class LargestDivisibleSubset {
  /*
      Largest Divisible Subset - Dynamic Programming
      Leetcode #368
      https://leetcode.com/problems/largest-divisible-subset/
      Difficulty: Medium
   */
  public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      List<Integer> maxSeq = new ArrayList<>();
      if (nums == null) return maxSeq;
      int n = nums.length;
      if (n == 0) return maxSeq;
      if (n == 1) return new ArrayList<Integer>() {{
        add(nums[0]);
      }};

      Arrays.sort(nums);
      int[] dp = new int[n];
      Arrays.fill(dp, 1);
      int maxCount = 1;

      for (int i = 1; i < nums.length; i++) {
        int localMax = 1;
        for (int j = i - 1; j >= 0; j--) {
          if (nums[i] % nums[j] == 0) {
            localMax = Math.max(localMax, dp[j] + 1);
          }
        }
        dp[i] = localMax;
        maxCount = Math.max(maxCount, dp[i]);
      }

      for (int i = n - 1; i >= 0; i--) {
        if (dp[i] == maxCount) {
          maxSeq.add(0, nums[i]);
          maxCount--;
        }
      }

      return maxSeq;
    }
  }

  /*
      Largest Divisible Subset - Brute Force
      Leetcode #368
      https://leetcode.com/problems/largest-divisible-subset/
      Difficulty: Medium
   */
  // ToDo: Not working yet
  public class Solution_2 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      List<Integer> maxSeq = new LinkedList<>();
      if (nums == null) return maxSeq;
      int n = nums.length;
      if (n == 0) return maxSeq;

      Arrays.sort(nums);
      for (int i = 0; i < n; i++) {
        LinkedList<Integer> currList = new LinkedList<>();
        currList.add(nums[i]);
        for (int j = i - 1; j >= 0; j--) {
          if (currList.getFirst() % nums[j] == 0) {
            currList.addFirst(nums[j]);
          }
        }

        if (currList.size() > maxSeq.size()) {
          maxSeq = currList;
        }
      }

      return maxSeq;
    }
  }

  /*
    Largest Divisible Subset - Brute Force
    Leetcode #368
    https://leetcode.com/problems/largest-divisible-subset/
    Difficulty: Medium
 */
  public class Solution_3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      List<Integer> maxSeq = new LinkedList<>();
      if (nums == null) return maxSeq;
      int n = nums.length;
      if (n == 0) return maxSeq;

      Arrays.sort(nums);
      for (int i = n - 1; i >= 0; i--) {
        LinkedList<Integer> currList = new LinkedList<>();
        currList.add(nums[i]);
        for (int j = i - 1; j >= 0; j--) {
          if (currList.getFirst() % nums[j] == 0) {
            currList.addFirst(nums[j]);
          }
        }

        if (currList.size() > maxSeq.size()) {
          maxSeq = currList;
        }
      }

      return maxSeq;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new LargestDivisibleSubset().new Solution();
      int[] test = {1};
      List<Integer> result = sol.largestDivisibleSubset(test);
      List<Integer> expected = new ArrayList<Integer>() {{
        add(1);
      }};
      assertEquals(1, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{1, 2, 3};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(1);
        add(3);
      }};
      assertEquals(2, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{1, 2, 4, 8};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(4);
        add(8);
      }};
      assertEquals(4, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{1, 2, 3, 4, 6, 24};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(1);
        add(3);
        add(6);
        add(24);
      }};
      assertEquals(4, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{546, 669};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(669);
      }};
      assertEquals(1, result.size());
      assertTrue(result.equals(expected));
    }

    @Test
    public void test2() {
      Solution_2 sol = new LargestDivisibleSubset().new Solution_2();
      int[] test = {1};
      List<Integer> result = sol.largestDivisibleSubset(test);
      List<Integer> expected = new ArrayList<Integer>() {{
        add(1);
      }};
      assertEquals(1, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{1, 2, 3};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(1);
        add(2);
      }};
      assertEquals(2, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{1, 2, 4, 8};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(4);
        add(8);
      }};
      assertEquals(4, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{1, 2, 3, 4, 6, 24};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(1);
        add(3);
        add(6);
        add(24);
      }};
      assertEquals(4, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{546, 669};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(546);
      }};
      assertEquals(1, result.size());
      assertTrue(result.equals(expected));
    }

    @Test
    public void test3() {
      Solution_3 sol = new LargestDivisibleSubset().new Solution_3();
      int[] test = {1};
      List<Integer> result = sol.largestDivisibleSubset(test);
      List<Integer> expected = new ArrayList<Integer>() {{
        add(1);
      }};
      assertEquals(1, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{1, 2, 3};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(1);
        add(3);
      }};
      assertEquals(2, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{1, 2, 4, 8};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(4);
        add(8);
      }};
      assertEquals(4, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{1, 2, 3, 4, 6, 24};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(1);
        add(3);
        add(6);
        add(24);
      }};
      assertEquals(4, result.size());
      assertTrue(result.equals(expected));

      test = new int[]{546, 669};
      result = sol.largestDivisibleSubset(test);
      expected = new ArrayList<Integer>() {{
        add(669);
      }};
      assertEquals(1, result.size());
      assertTrue(result.equals(expected));
    }
  }
}
