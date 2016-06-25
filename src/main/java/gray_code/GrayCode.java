package gray_code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GrayCode {
  /*
      Gray Code - Recursive
      Leetcode #89
      https://leetcode.com/problems/gray-code/
      Difficulty: Medium
   */
  public class Solution {
    public ArrayList<Integer> grayCode(int n) {
      ArrayList<Integer> codeList = new ArrayList<Integer>();
      if (n < 0) return codeList;
      codeList.add(0);
      for (int i = 0; i < n; i++) {
        int inc = 1 << i;
        for (int j = codeList.size() - 1; j >= 0; j--) {
          codeList.add(codeList.get(j) + inc);
        }
      }
      return codeList;
    }
  }

  /*
      Gray Code - Formula
      Leetcode #89
      https://leetcode.com/problems/gray-code/
      Difficulty: Medium
   */
  public class Solution_2 {
    public List<Integer> grayCode(int n) {
      List<Integer> codeList = new ArrayList<>();
      if (n < 0) return codeList;
      for (int i = 0; i < (1 << n); i++) {
        codeList.add(i ^ (i >> 1));
      }
      return codeList;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new GrayCode().new Solution();
      List<Integer> grayCodes = sol.grayCode(2);
      assertEquals(4, grayCodes.size());
      assertEquals(0, (int) grayCodes.get(0));
      assertEquals(1, (int) grayCodes.get(1));
      assertEquals(3, (int) grayCodes.get(2));
      assertEquals(2, (int) grayCodes.get(3));
    }

    @Test
    public void test2() {
      Solution_2 sol = new GrayCode().new Solution_2();
      List<Integer> grayCodes = sol.grayCode(2);
      assertEquals(4, grayCodes.size());
      assertEquals(0, (int) grayCodes.get(0));
      assertEquals(1, (int) grayCodes.get(1));
      assertEquals(3, (int) grayCodes.get(2));
      assertEquals(2, (int) grayCodes.get(3));
    }
  }
}
