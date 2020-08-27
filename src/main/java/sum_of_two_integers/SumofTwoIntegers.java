package sum_of_two_integers;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SumofTwoIntegers {
  /*
      Sum of Two Integers
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

  /*
      Sum of Two Integers - One Line
      Leetcode #371
      https://leetcode.com/problems/sum-of-two-integers/
      Difficulty: Easy
   */
  public class Solution_2 {
    public int getSum(int a, int b) {
      return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
  }

  /*
      Sum of Two Integers - One Line
      Leetcode #371
      https://leetcode.com/problems/sum-of-two-integers/
      Difficulty: Easy
   */
  public class Solution_3 {
    public int getSum(int a, int b) {
      if (b == 0) return a;
      int sum = a ^ b;
      int carry = (a & b) << 1;
      return getSum(sum, carry);
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

    @Test
    public void test2() {
      Solution_2 sol = new SumofTwoIntegers().new Solution_2();
      assertEquals(7, sol.getSum(2, 5));
      assertEquals(7, sol.getSum(1, 6));
      assertEquals(7, sol.getSum(4, 3));
    }

    @Test
    public void test3() {
      Solution_3 sol = new SumofTwoIntegers().new Solution_3();
      assertEquals(7, sol.getSum(2, 5));
      assertEquals(7, sol.getSum(1, 6));
      assertEquals(7, sol.getSum(4, 3));
    }
  }
}

