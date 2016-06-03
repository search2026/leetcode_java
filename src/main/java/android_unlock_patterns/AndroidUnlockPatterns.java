package android_unlock_patterns;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
            int rslt = 0;
            int[][] start = {{0, 0}, {0, 1}, {1, 1}};
            boolean[][] board = new boolean[3][3];
            for (int len = m; len <= n; len++) {
                for (int i = 0; i < 3; i++) {
                    int x = start[i][0], y = start[i][1];
                    search(x, y, len, board);
                    rslt += i != 2 ? res * 4 : res;
                    res = 0;
                }
            }
            return rslt;
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
        private int search(boolean vis[], int[][] skip, int cur, int remain) {
            if (remain < 0) return 0;
            if (remain == 0) return 1;
            vis[cur] = true;
            int rst = 0;
            for (int i = 1; i <= 9; ++i) {
                // If vis[i] is not visited and (two numbers are adjacent or skip number is already visited)
                if (!vis[i] && (skip[i][cur] == 0 || (vis[skip[i][cur]]))) {
                    rst += search(vis, skip, i, remain - 1);
                }
            }
            vis[cur] = false;
            return rst;
        }

        public int numberOfPatterns(int m, int n) {
            // Skip array represents number to skip between two pairs
            int skip[][] = new int[10][10];
            skip[1][3] = skip[3][1] = 2;
            skip[1][7] = skip[7][1] = 4;
            skip[3][9] = skip[9][3] = 6;
            skip[7][9] = skip[9][7] = 8;
            skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
            boolean visited[] = new boolean[10];
            int rslt = 0;
            // search search each length from m to n
            for (int i = m; i <= n; ++i) {
                rslt += search(visited, skip, 1, i - 1) * 4; // 1, 3, 7, 9 are symmetric
                rslt += search(visited, skip, 2, i - 1) * 4; // 2, 4, 6, 8 are symmetric
                rslt += search(visited, skip, 5, i - 1);     // 5
            }
            return rslt;
        }
    }

    /*
        Android Unlock Patterns
        Leetcode #351
        https://leetcode.com/discuss/questions/oj/android-unlock-patterns?sort=votes
        http://www.cnblogs.com/grandyang/p/5541012.html
        Difficulty: Medium
     */
    public class Solution_3 {
        private int count(int m, int n, int used, int i1, int j1) {
            int rslt = m <= 0 ? 1 : 0;
            if (n == 0) return 1;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    int I = i1 + i, J = j1 + j, used2 = used | (1 << (i * 3 + j));
                    if (used2 > used && (((I % 2 > 0) || J % 2 > 0 ||
                            used2 > 0 & (1 << (I / 2 * 3 + J / 2) > 0)))) {
                        rslt += count(m - 1, n - 1, used2, i, j);
                    }
                }
            }
            return rslt;
        }

        public int numberOfPatterns(int m, int n) {
            return count(m, n, 0, 1, 1);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new AndroidUnlockPatterns().new Solution();
            assertEquals(1, 1);
        }
    }
}

