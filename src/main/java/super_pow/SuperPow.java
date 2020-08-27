package super_pow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperPow {
  /*
      Super Pow - Iterative
      Leetcode #372
      https://leetcode.com/problems/super-pow/
      Difficulty: Medium
   */
  public class Solution {
    private int pow(int a, int b, int c) {
      long module = 1;
      long p = a;
      while (b > 0) {
        if ((b & 1) == 1) {
          module = (module * p) % c;
        }
        p = (p * p) % c;
        b >>= 1;
      }
      return (int) (module % c);
    }

    public int superPow(int a, int[] b) {
      if (b == null || b.length == 0) return 1;

      int module = 1, p = a;
      for (int i = b.length - 1; i >= 0; i--) {
        module = module * pow(p, b[i], 1337) % 1337;
        p = pow(p, 10, 1337);
      }

      return module;
    }
  }

  /*
      Super Pow - Recursion
      Leetcode #372
      https://leetcode.com/problems/super-pow/
      Difficulty: Medium
   */
  public class Solution_2 {
    private int pow(int a, int b, int c) {
      if (b == 0) return 1;
      if (b == 1) return a % c;
      return pow(a % c, b / 2, c) * pow(a % c, b - b / 2, c) % c;
    }

    public int superPow(int a, int[] b) {
      if (b == null || b.length == 0) return 1;

      int module = 1;
      for (int i=0; i< b.length; i++) {
        module = pow(module, 10, 1337) * pow (a, b[i], 1337) % 1337;
      }

      return module;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new SuperPow().new Solution();
      assertEquals(8, sol.superPow(2, new int[]{3}));
      assertEquals(1024, sol.superPow(2, new int[]{1, 0}));
      //assertEquals(1198, sol.superPow((2147483674 % 1337, new int[]{2, 0, 0}));
      assertEquals(426, sol.superPow(797, new int[]{1, 5, 3, 1, 4, 7, 9, 3}));
      assertEquals(660, sol.superPow(3387647, new int[]{5, 5, 5, 4, 7, 9, 3}));
    }

    @Test
    public void test2() {
      Solution_2 sol = new SuperPow().new Solution_2();
      assertEquals(8, sol.superPow(2, new int[]{3}));
      assertEquals(1024, sol.superPow(2, new int[]{1, 0}));
      assertEquals(426, sol.superPow(797, new int[]{1, 5, 3, 1, 4, 7, 9, 3}));
      assertEquals(660, sol.superPow(3387647, new int[]{5, 5, 5, 4, 7, 9, 3}));
    }
  }
}

