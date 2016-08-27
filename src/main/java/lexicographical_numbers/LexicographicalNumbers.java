package lexicographical_numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LexicographicalNumbers {
  /*
      Lexicographical Numbers
      Leetcode #386
      https://leetcode.com/problems/lexicographical-numbers/
      Difficulty: Medium
   */
  public class Solution {
    public List<Integer> lexicalOrder(int n) {
      List<Integer> list = new ArrayList<>(n);
      int curr = 1;
      for (int i = 1; i <= n; i++) {
        list.add(curr);
        if (curr * 10 <= n) {
          curr *= 10;
        } else if (curr % 10 != 9 && curr + 1 <= n) {
          curr++;
        } else {
          while ((curr / 10) % 10 == 9) {
            curr /= 10;
          }
          curr = curr / 10 + 1;
        }
      }
      return list;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new LexicographicalNumbers().new Solution();
      List<Integer> rslt = sol.lexicalOrder(13);
      assertEquals(13, rslt.size());
      assertEquals(1, (int) rslt.get(0));
      assertEquals(10, (int) rslt.get(1));
      assertEquals(11, (int) rslt.get(2));
      assertEquals(12, (int) rslt.get(3));
      assertEquals(13, (int) rslt.get(4));
      assertEquals(2, (int) rslt.get(5));
      assertEquals(3, (int) rslt.get(6));
      assertEquals(4, (int) rslt.get(7));
      assertEquals(5, (int) rslt.get(8));
      assertEquals(6, (int) rslt.get(9));
      assertEquals(7, (int) rslt.get(10));
      assertEquals(8, (int) rslt.get(11));
      assertEquals(9, (int) rslt.get(12));
    }
  }
}

