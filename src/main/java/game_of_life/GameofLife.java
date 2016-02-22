package game_of_life;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameofLife {
    /*
        Game of Life
        https://leetcode.com/problems/game-of-life/
        leetcode 289
        Difficulty: Hard
     */
    public class Solution {
        public void gameOfLife(int[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return;
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int lives = 0;
                    //up
                    if (i > 0) {
                        if (board[i - 1][j] == 1 || board[i - 1][j] == 2) lives++;
                    }
                    //down
                    if (i < m - 1) {
                        if (board[i + 1][j] == 1 || board[i + 1][j] == 2) lives++;
                    }
                    //left
                    if (j > 0) {
                        if (board[i][j - 1] == 1 || board[i][j - 1] == 2) lives++;
                    }
                    //right
                    if (j < n - 1) {
                        if (board[i][j + 1] == 1 || board[i][j + 1] == 2) lives++;
                    }
                    //left up
                    if (i > 0 && j > 0) {
                        if (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2) lives++;
                    }
                    //right up
                    if (i > 0 && j < n - 1) {
                        if (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2) lives++;
                    }
                    //left down
                    if (i < m - 1 && j > 0) {
                        if (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2) lives++;
                    }
                    //right down
                    if (i < m - 1 && j < n - 1) {
                        if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2) lives++;
                    }


                    //update board[i][j]
                    if (board[i][j] == 0) {
                        if (lives == 3) board[i][j] = 3;
                        else board[i][j] = 0;
                    } else { //board[i][j] == 1
                        if (lives < 2 || lives > 3) board[i][j] = 2;
                        else board[i][j] = 1;
                    }
                }
            }

            //decode
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
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
        Game of Life II
        https://segmentfault.com/a/1190000003819277
        Difficulty: Hard
    */
    public class Solution_3 {
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
