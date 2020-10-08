package android_unlock_patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndroidUnlockPatterns {
  /*
      Android Unlock Patterns
      Leetcode #351
      https://leetcode.com/discuss/questions/oj/android-unlock-patterns?sort=votes
      http://www.cnblogs.com/grandyang/p/5541012.html
      Difficulty: Medium
   */
  public class Solution {
    int res = 0;

    private void search(int x, int y, int len, boolean[][] board) {
      if (len == 1) {
        res++;
        return;
      }
      board[x][y] = true;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (board[i][j]
                  || (i == x && Math.abs(j - y) > 1 && !board[x][1])
                  || (j == y && Math.abs(i - x) > 1 && !board[1][y])
                  || ((i + j == x + y || i - x == j - y) && Math.abs(i - x) > 1 && !board[1][1])) {
            continue;
          }
          search(i, j, len - 1, board);
        }
      }
      board[x][y] = false;
    }

    public int numberOfPatterns(int m, int n) {
      int res = 0;
      int[][] start = {{0, 0}, {0, 1}, {1, 1}};
      boolean[][] board = new boolean[3][3];
      for (int len = m; len <= n; len++) {
        for (int i = 0; i < 3; i++) {
          int x = start[i][0], y = start[i][1];
          search(x, y, len, board);
          res += i != 2 ? this.res * 4 : this.res;
          this.res = 0;
        }
      }
      return res;
    }
  }

  /*
      Android Unlock Patterns
      Leetcode #351
      https://leetcode.com/discuss/questions/oj/android-unlock-patterns?sort=votes
      http://www.cnblogs.com/grandyang/p/5541012.html
      Difficulty: Medium
   */
  public class Solution_2 {
    private int search(int[][] skip, boolean visited[], int curr, int rem) {
      if (rem < 0) return 0;
      if (rem == 0) return 1;
      visited[curr] = true;
      int count = 0;
      for (int i = 1; i <= 9; ++i) {
        if (!visited[i] && (skip[i][curr] == 0 || (visited[skip[i][curr]]))) {
          count += search(skip, visited, i, rem - 1);
        }
      }
      visited[curr] = false;
      return count;
    }

    public int numberOfPatterns(int m, int n) {
      int skip[][] = new int[10][10];
      skip[1][3] = skip[3][1] = 2;
      skip[1][7] = skip[7][1] = 4;
      skip[3][9] = skip[9][3] = 6;
      skip[7][9] = skip[9][7] = 8;
      skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
      boolean visited[] = new boolean[10];
      int count = 0;

      for (int i = m; i <= n; ++i) {
        count += search(skip, visited, 1, i - 1) * 4; // 1, 3, 7, 9 are symmetric
        count += search(skip, visited, 2, i - 1) * 4; // 2, 4, 6, 8 are symmetric
        count += search(skip, visited, 5, i - 1);     // 5
      }

      return count;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new AndroidUnlockPatterns().new Solution();
      assertEquals(9, sol.numberOfPatterns(1, 1));
      assertEquals(385, sol.numberOfPatterns(1, 3));
      assertEquals(320, sol.numberOfPatterns(3, 3));
      assertEquals(34792, sol.numberOfPatterns(4, 6));
      assertEquals(33168, sol.numberOfPatterns(5, 6));
      assertEquals(26016, sol.numberOfPatterns(6, 6));
    }

    @Test
    public void test2() {
      Solution_2 sol = new AndroidUnlockPatterns().new Solution_2();
      assertEquals(9, sol.numberOfPatterns(1, 1));
      assertEquals(385, sol.numberOfPatterns(1, 3));
      assertEquals(320, sol.numberOfPatterns(3, 3));
      assertEquals(34792, sol.numberOfPatterns(4, 6));
      assertEquals(33168, sol.numberOfPatterns(5, 6));
      assertEquals(26016, sol.numberOfPatterns(6, 6));
    }
  }
}

