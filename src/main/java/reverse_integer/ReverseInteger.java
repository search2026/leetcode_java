package reverse_integer;

import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseInteger {
  /*
      Reverse Integer
      Leetcode #7
      https://leetcode.com/problems/reverse-integer/
      Difficulty: Easy
   */
  public class Solution {
    public int reverse(int x) {
      int reversed = 0;
      while (x!=0) {
        // handle overflow/underflow
        if (Math.abs(reversed) > 214748364) {
          return 0;
        }
        reversed = reversed * 10 + x % 10;
        x /= 10;
      }

      return reversed;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new ReverseInteger().new Solution();
      assertEquals(0, sol.reverse(0));
      assertEquals(1, sol.reverse(1000));
      assertEquals(321, sol.reverse(123));
      assertEquals(-75563, sol.reverse(-36557));
    }
  }
}
