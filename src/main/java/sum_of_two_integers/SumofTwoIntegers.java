package sum_of_two_integers;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class SumofTwoIntegers {
  /*
      Sum of Two Integersv
      Leetcode #371
      https://leetcode.com/problems/sum-of-two-integers/
      Difficulty: Easy
   */
  public class Solution {
    public int getSum(int a, int b) {
      while (b != 0) {
        int carry = a & b;
        a = a ^ b;
        b = carry << 1;
      }
      return a;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new SumofTwoIntegers().new Solution();
      assertEquals(7, sol.getSum(2, 5));
      assertEquals(7, sol.getSum(1, 6));
      assertEquals(7, sol.getSum(4, 3));
    }
  }
}

