package game_of_life;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameofLife {
    /*
        Game of Life
        leetcode #289
        https://leetcode.com/problems/game-of-life/
        Difficulty: Hard
     */
    public class Solution {
        int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

        public void gameOfLife(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int live = 0;
                    for (int[] d : dir) {
                        if (d[0] + i < 0 || d[0] + i >= board.length || d[1] + j < 0 || d[1] + j >= board[0].length)
                            continue;
                        if (board[d[0] + i][d[1] + j] == 1 || board[d[0] + i][d[1] + j] == 2) live++;
                    }
                    if (board[i][j] == 0 && live == 3) board[i][j] = 3;
                    if (board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 2;
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] %= 2;
                }
            }
        }
    }

    /*
        Game of Life
        https://leetcode.com/problems/game-of-life/
        Difficulty: Hard
     */
    public class Solution_2 {
        public void gameOfLife(int[][] board) {
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int lives = 0;
                    // 累加上下左右及四个角还有自身的值
                    for (int y = Math.max(i - 1, 0); y <= Math.min(i + 1, m - 1); y++) {
                        for (int x = Math.max(j - 1, 0); x <= Math.min(j + 1, n - 1); x++) {
                            // 累加bit1的值
                            lives += board[y][x] & 1;
                        }
                    }
                    // 如果自己是活的，周边有两个活的，lives是3
                    // 如果自己是死的，周边有三个活的，lives是3
                    // 如果自己是活的，周边有三个活的，lives减自己是3
                    if (lives == 3 || lives - board[i][j] == 3) {
                        board[i][j] |= 2;
                    }
                }
            }
            // 右移就是新的值
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] >>>= 1;
                }
            }
        }
    }

    /*
        Game of Life
        https://leetcode.com/problems/game-of-life/
        Difficulty: Hard
     */
    public class Solution_3 {
        /*
        [2nd bit, 1st bit] = [next state, current state]

        - 00  dead (next) <- dead (current)
        - 01  dead (next) <- live (current)
        - 10  live (next) <- dead (current)
        - 11  live (next) <- live (current)
         */
        public void gameOfLife(int[][] board) {
            if (board == null || board.length == 0) return;
            int m = board.length, n = board[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int lives = liveNeighbors(board, m, n, i, j);

                    // In the beginning, every 2nd bit is 0;
                    // So we only need to care about when will the 2nd bit become 1.
                    if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                        board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                    }
                    if (board[i][j] == 0 && lives == 3) {
                        board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] >>= 1;  // Get the 2nd state.
                }
            }
        }

        private int liveNeighbors(int[][] board, int m, int n, int i, int j) {
            int lives = 0;
            for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
                for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                    lives += board[x][y] & 1;
                }
            }
            lives -= board[i][j] & 1;
            return lives;
        }
    }

    /*
        Game of Life II
        https://segmentfault.com/a/1190000003819277
        Difficulty: Hard
    */
    public class Solution_4 {
        public void solveOneD(int rounds, int[] board) {
            int n = board.length;
            for (int i = 0; i < n; i++) {
                int lives = board[(i + n + 1) % n] % 2 + board[(i + n - 1) % n] % 2;
                if (lives == 1) {
                    board[i] = board[i] % 2 + 2;
                } else {
                    board[i] = board[i];
                }
            }
            for (int i = 0; i < n; i++) {
                board[i] = board[i] >= 2 ? (board[i] + 1) % 2 : board[i] % 2;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new GameofLife().new Solution();
            assertEquals(3, 3);
        }
    }
}
