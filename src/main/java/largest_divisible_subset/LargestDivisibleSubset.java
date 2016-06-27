package largest_divisible_subset;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class LargestDivisibleSubset {
  /*
      Largest Divisible Subset
      Leetcode #368
      https://leetcode.com/problems/largest-divisible-subset/
      Difficulty: Medium
   */
  public class Solution {
    public int[] largestDivisibleSubset(int[] nums) {
      if (nums == null) return new int[]{};
      int n = nums.length;
      if (n == 0) return new int[]{};
      if (n == 1) return nums;

      Arrays.sort(nums);
      Map<Integer, Integer> map = new HashMap<>();
      int[] dp = new int[n];
      Arrays.fill(dp, 1);
      int maxCount = Integer.MIN_VALUE;
      int maxNum = Integer.MIN_VALUE; // the largest sequence ends with this number

      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if ((nums[j] % nums[i] == 0) && (dp[j] < dp[i] + 1)) {
            map.put(nums[j], nums[i]);
            dp[j] = dp[i] + 1;

            if (dp[j] > maxCount) {
              maxCount = dp[j];
              maxNum = nums[j];
            }
          }
        }
      }

      if (maxCount == Integer.MIN_VALUE) return new int[]{nums[0]};

      // backtracking map to get the largest sequence
      List<Integer> list = new LinkedList<Integer>();
      list.add(maxNum);
      while (map.containsKey(maxNum)) {
        maxNum = map.get(maxNum);
        list.add(0, maxNum);
      }

      // Please let me know if there is a better way to convert from
      // Integer List to int array
      int[] maxSeq = new int[list.size()];
      for (int i = 0; i < list.size(); i++)
        maxSeq[i] = list.get(i);

      return maxSeq;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new LargestDivisibleSubset().new Solution();
      int[] test = {1, 2, 3};
      int[] result = sol.largestDivisibleSubset(test);
      int[] expected = {1, 2};
      assertArrayEquals(expected, result);

      test = new int[]{1, 2, 4, 8};
      result = sol.largestDivisibleSubset(test);
      expected = new int[]{1, 2, 4, 8};
      assertArrayEquals(expected, result);

      test = new int[]{1};
      result = sol.largestDivisibleSubset(test);
      expected = new int[]{1};
      assertArrayEquals(expected, result);

      test = new int[]{546, 669};
      result = sol.largestDivisibleSubset(test);
      expected = new int[]{546};
      assertArrayEquals(expected, result);
    }
  }
}

