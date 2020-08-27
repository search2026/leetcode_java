package count_numbers_with_unique_digits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountNumberswithUniqueDigits {
  /*
      Count Numbers with Unique Digits - BackTracking
      Leetcode #357
      https://leetcode.com/problems/count-numbers-with-unique-digits/
      Difficulty: Medium
   */
  public class Solution {
    private int search(long prev, long max, boolean[] visited) {
      int count = 0;
      if (prev < max) {
        count += 1;
      } else {
        return count;
      }

      for (int i = 0; i < 10; i++) {
        if (!visited[i]) {
          visited[i] = true;
          long cur = 10 * prev + i;
          count += search(cur, max, visited);
          visited[i] = false;
        }
      }

      return count;
    }

    public int countNumbersWithUniqueDigits(int n) {
      if (n == 0) return 1;
      if (n > 10) return countNumbersWithUniqueDigits(10);

      int count = 1; // x == 0
      long max = (long) Math.pow(10, n);
      boolean[] visited = new boolean[10];

      for (int i = 1; i < 10; i++) {
        visited[i] = true;
        count += search(i, max, visited);
        visited[i] = false;
      }

      return count;
    }
  }

  /*
      Count Numbers with Unique Digits - Dynamic Programming
      Leetcode #357
      https://leetcode.com/problems/count-numbers-with-unique-digits/
      Difficulty: Medium
   */
  public class Solution_2 {
    public int countNumbersWithUniqueDigits(int n) {
      if (n == 0) return 1;
      if (n > 10) n = 10;

      int count = 10;
      int uniqueDigits = 9;
      int available = 9;
      while (n-- > 1 && available > 0) {
        uniqueDigits = uniqueDigits * available;
        count += uniqueDigits;
        available--;
      }
      return count;
    }
  }


  /*
      Count Numbers with Unique Digits - Dynamic Programming
      Leetcode #357
      https://leetcode.com/problems/count-numbers-with-unique-digits/
      Difficulty: Medium
   */
  public class Solution_3 {
    public int countNumbersWithUniqueDigits(int n) {
      if (n == 0) return 1;
      if (n > 10) n = 10;

      int count = 10, curr = 9;
      for (int i = 2; i <= n; ++i) {
        curr *= (11 - i);
        count += curr;
      }
      return count;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new CountNumberswithUniqueDigits().new Solution();
      assertEquals(1, sol.countNumbersWithUniqueDigits(0));
      assertEquals(10, sol.countNumbersWithUniqueDigits(1));
      assertEquals(91, sol.countNumbersWithUniqueDigits(2));
      assertEquals(739, sol.countNumbersWithUniqueDigits(3));
      assertEquals(5275, sol.countNumbersWithUniqueDigits(4));
      assertEquals(32491, sol.countNumbersWithUniqueDigits(5));
      assertEquals(168571, sol.countNumbersWithUniqueDigits(6));
      assertEquals(712891, sol.countNumbersWithUniqueDigits(7));
      assertEquals(2345851, sol.countNumbersWithUniqueDigits(8));
      assertEquals(5611771, sol.countNumbersWithUniqueDigits(9));
      assertEquals(8877691, sol.countNumbersWithUniqueDigits(10));
      assertEquals(8877691, sol.countNumbersWithUniqueDigits(11));

    }

    @Test
    public void test2() {
      Solution_2 sol = new CountNumberswithUniqueDigits().new Solution_2();
      assertEquals(1, sol.countNumbersWithUniqueDigits(0));
      assertEquals(10, sol.countNumbersWithUniqueDigits(1));
      assertEquals(91, sol.countNumbersWithUniqueDigits(2));
      assertEquals(739, sol.countNumbersWithUniqueDigits(3));
      assertEquals(5275, sol.countNumbersWithUniqueDigits(4));
      assertEquals(32491, sol.countNumbersWithUniqueDigits(5));
      assertEquals(168571, sol.countNumbersWithUniqueDigits(6));
      assertEquals(712891, sol.countNumbersWithUniqueDigits(7));
      assertEquals(2345851, sol.countNumbersWithUniqueDigits(8));
      assertEquals(5611771, sol.countNumbersWithUniqueDigits(9));
      assertEquals(8877691, sol.countNumbersWithUniqueDigits(10));
      assertEquals(8877691, sol.countNumbersWithUniqueDigits(11));
    }

    @Test
    public void test3() {
      Solution_3 sol = new CountNumberswithUniqueDigits().new Solution_3();
      assertEquals(1, sol.countNumbersWithUniqueDigits(0));
      assertEquals(10, sol.countNumbersWithUniqueDigits(1));
      assertEquals(91, sol.countNumbersWithUniqueDigits(2));
      assertEquals(739, sol.countNumbersWithUniqueDigits(3));
      assertEquals(5275, sol.countNumbersWithUniqueDigits(4));
      assertEquals(32491, sol.countNumbersWithUniqueDigits(5));
      assertEquals(168571, sol.countNumbersWithUniqueDigits(6));
      assertEquals(712891, sol.countNumbersWithUniqueDigits(7));
      assertEquals(2345851, sol.countNumbersWithUniqueDigits(8));
      assertEquals(5611771, sol.countNumbersWithUniqueDigits(9));
      assertEquals(8877691, sol.countNumbersWithUniqueDigits(10));
      assertEquals(8877691, sol.countNumbersWithUniqueDigits(11));
    }
  }
}

