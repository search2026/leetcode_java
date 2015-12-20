package game_of_life;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameofLife {
    /*
        Game of Life
        https://leetcode.com/problems/game-of-life/
        Difficulty: Hard
     */
    public class Solution {
        final int DEAD = 0;
        final int ALIVE = 1;
        final int DEAD_TO_DEAD = 0;
        final int ALIVE_TO_ALIVE = 1;
        final int ALIVE_TO_DEAD = 2;
        final int DEAD_TO_ALIVE = 3;

        private boolean isAliveOld(int obj) {
            if (obj == ALIVE_TO_ALIVE || obj == ALIVE_TO_DEAD) {
                return true;
            } else {
                return false;
            }
        }

        private boolean isAliveNew(int obj) {
            if (obj % 2 == 1) {
                return true;
            } else {
                return false;
            }
        }

        public void gameOfLife(int[][] board) {
            if (board == null) {
                return;
            }
            int height = board.length;
            if (height == 0) {
                return;
            }
            int width = board[0].length;
            if (width == 0) {
                return;
            }

            int counter = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    counter = 0;
                    if (i > 0 && j > 0 && isAliveOld(board[i - 1][j - 1])) {
                        counter++;
                    }
                    if (i > 0 && isAliveOld(board[i - 1][j])) {
                        counter++;
                    }
                    if (i > 0 && j < width - 1 && isAliveOld(board[i - 1][j + 1])) {
                        counter++;
                    }
                    if (j > 0 && isAliveOld(board[i][j - 1])) {
                        counter++;
                    }
                    if (j < width - 1 && isAliveOld(board[i][j + 1])) {
                        counter++;
                    }
                    if (i < height - 1 && j > 0 && isAliveOld(board[i + 1][j - 1])) {
                        counter++;
                    }
                    if (i < height - 1 && isAliveOld(board[i + 1][j])) {
                        counter++;
                    }
                    if (i < height - 1 && j < width - 1 && isAliveOld(board[i + 1][j + 1])) {
                        counter++;
                    }

                    if (isAliveOld(board[i][j])) {
                        if (counter < 2) {
                            //1.存活单位周边的存活单位少于2个，该单位死亡
                            board[i][j] = ALIVE_TO_DEAD;
                        } else if (counter == 2 || counter == 3) {
                            //2.存活单位周边的存活单位有2-3个，该单位继续存活
                            board[i][j] = ALIVE_TO_ALIVE;
                        } else {
                            //3.存活单位周边的存活单位多余3个，该单位死亡
                            board[i][j] = ALIVE_TO_DEAD;
                        }
                    } else {
                        if (counter == 3) {
                            //4.死亡单位周边的存活单位恰好为3个，该单位变为存活状态
                            board[i][j] = DEAD_TO_ALIVE;
                        } else {
                            board[i][j] = DEAD_TO_DEAD;
                        }
                    }
                }
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (isAliveNew(board[i][j])) {
                        board[i][j] = ALIVE;
                    } else {
                        board[i][j] = DEAD;
                    }
                }
            }
        }
    }

    /*
    Game of Life II
    https://segmentfault.com/a/1190000003819277
    Difficulty: Hard
 */
    public class SolutionII {
        public void solveOneDWithTable(int[] board) {
            int n = board.length;
            int[] lookupTable = {0, 1, 0, 1, 1, 0, 1, 0};
            int[] buffer = new int[n];
            int env = board[n - 1] * 2 + board[0] * 1;
            for (int i = 0; i < n; i++) {
                env = (env % 4) * 2 + board[(i + n + 1) % n] * 1;
                buffer[i] = (lookupTable[env] + board[i]) % 2;
                System.out.println(env);
            }
            for (int i = 0; i < n; i++) {
                board[i] = buffer[i];
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new GameofLife().new Solution();
        }
    }
}
