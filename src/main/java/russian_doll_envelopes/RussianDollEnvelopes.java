package russian_doll_envelopes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RussianDollEnvelopes {
  /*
      Russian Doll Envelopes - Dynamic Programming
      Leetcode #354
      https://leetcode.com/problems/russian-doll-envelopes/
      Difficulty: Hard
   */
  public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
      if (envelopes == null ||
              envelopes.length == 0 ||
              envelopes[0] == null ||
              envelopes[0].length != 2) return 0;

      Arrays.sort(envelopes, new Comparator<int[]>() {
        @Override
        public int compare(int[] e1, int[] e2) {
          if (e1[0] == e2[0])
            return e1[1] - e2[1];
          return e1[0] - e2[0];
        }
      });

      int n = envelopes.length;
      int[] dp = new int[n];
      int maxLen = 0;

      for (int i = 0; i < n; i++) {
        dp[i] = 1;
        for (int j = 0; j < n; j++) {
          if (envelopes[i][0] > envelopes[j][0] &&
                  envelopes[i][1] > envelopes[j][1])
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }

        maxLen = Math.max(maxLen, dp[i]);
      }

      return maxLen;
    }
  }

  /*
      Russian Doll Envelopes - Binary Search
      Leetcode #354
      https://leetcode.com/problems/russian-doll-envelopes/
      Difficulty: Hard
   */
  public class Solution_2 {
    private int search(int[][] matrix, int maxSize, int[] envelop) {
      int left = 1, right = maxSize;
      if (envelop[1] > matrix[right][1]) return right + 1;
      if (envelop[1] <= matrix[left][1]) return left;

      while (left + 1 < right) {
        int mid = left + (right - left) / 2;
        if (envelop[1] > matrix[mid][1]) left = mid;
        else right = mid;
      }

      return right;
    }

    public int maxEnvelopes(int[][] envelopes) {
      if (envelopes == null ||
              envelopes.length == 0 ||
              envelopes[0] == null ||
              envelopes[0].length != 2) return 0;

      Arrays.sort(envelopes, new Comparator<int[]>() {
        @Override
        public int compare(int[] e1, int[] e2) {
          if (e1[0] == e2[0])
            return e2[1] - e1[1];
          return e1[0] - e2[0];
        }
      });

      int n = envelopes.length;
      int[][] matrix = new int[n + 1][2];
      int maxLen = 1;
      matrix[1][0] = envelopes[0][0];
      matrix[1][1] = envelopes[0][1];
      for (int i = 1; i < n; i++) {
        int idx = search(matrix, maxLen, envelopes[i]);
        if (idx > maxLen) maxLen++;
        matrix[idx][0] = envelopes[i][0];
        matrix[idx][1] = envelopes[i][1];
      }

      return maxLen;
    }
  }

  /*
      Russian Doll Envelopes - Binary Search
      Leetcode #354
      https://leetcode.com/problems/russian-doll-envelopes/
      Difficulty: Hard
   */
  public class Solution_3 {
    public int maxEnvelopes(int[][] envelopes) {
      if (envelopes == null ||
              envelopes.length == 0 ||
              envelopes[0] == null ||
              envelopes[0].length != 2) return 0;

      Arrays.sort(envelopes, new Comparator<int[]>() {
        public int compare(int[] a1, int[] a2) {
          if (a1[0] != a2[0])
            return a1[0] - a2[0];
          return a2[1] - a1[1]; // key
        }
      });

      int n = envelopes.length;
      int dp[] = new int[n];
      int maxLen = 0;
      for (int[] envelope : envelopes) {
        int index = Arrays.binarySearch(dp, 0, maxLen, envelope[1]);
        if (index < 0) {
          index = -(index + 1);
        }
        dp[index] = envelope[1];
        if (index == maxLen) {
          maxLen++;
        }
      }

      return maxLen;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new RussianDollEnvelopes().new Solution();
      int[][] test1 = {
              {5, 4},
              {6, 4},
              {6, 7},
              {2, 3}
      };
      assertEquals(3, sol.maxEnvelopes(test1));

      int[][] test2 = {
              {4, 5},
              {4, 6},
              {6, 7},
              {2, 3},
              {1, 1}
      };
      assertEquals(4, sol.maxEnvelopes(test2));
    }

    @Test
    public void test2() {
      Solution_2 sol = new RussianDollEnvelopes().new Solution_2();
      int[][] test1 = {
              {5, 4},
              {6, 4},
              {6, 7},
              {2, 3}
      };
      assertEquals(3, sol.maxEnvelopes(test1));

      int[][] test2 = {
              {4, 5},
              {4, 6},
              {6, 7},
              {2, 3},
              {1, 1}
      };
      assertEquals(4, sol.maxEnvelopes(test2));
    }

    @Test
    public void test3() {
      Solution_3 sol = new RussianDollEnvelopes().new Solution_3();
      int[][] test1 = {
              {5, 4},
              {6, 4},
              {6, 7},
              {2, 3}
      };
      assertEquals(3, sol.maxEnvelopes(test1));

      int[][] test2 = {
              {4, 5},
              {4, 6},
              {6, 7},
              {2, 3},
              {1, 1}
      };
      assertEquals(4, sol.maxEnvelopes(test2));
    }
  }
}

