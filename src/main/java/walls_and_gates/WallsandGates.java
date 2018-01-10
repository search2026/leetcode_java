package walls_and_gates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WallsandGates {
    /*
        Walls and Gates - BFS
        Leetcode #286
        https://leetcode.com/discuss/questions/oj/walls-and-gates?sort=votes
        http://www.cnblogs.com/EdwardLiu/p/5077950.html
        Difficulty: Medium
     */
    public class Solution {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private void search(int[][] rooms, int i, int j, int dis) {
            if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) return;
            if (rooms[i][j] < dis) return;

            rooms[i][j] = dis;

            for (int[] dir : dirs)
                search(rooms, i + dir[0], j + dir[1], dis + 1);
        }

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

            for (int i = 0; i < rooms.length; ++i) {
                for (int j = 0; j < rooms[0].length; j++)
                    if (rooms[i][j] == 0) search(rooms, i, j, 0);
            }
        }
    }

    /*
        Walls and Gates - DFS
        Leetcode #286
        https://leetcode.com/discuss/questions/oj/walls-and-gates?sort=votes
        http://www.cnblogs.com/EdwardLiu/p/5077950.html
        Difficulty: Medium
     */
    public class Solution_2 {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private void search(int[][] rooms, int i, int j, int d) {
            if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
            rooms[i][j] = d;
            for (int[] dir : dirs)
                search(rooms, i + dir[0], j + dir[1], d + 1);
        }

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

            for (int i = 0; i < rooms.length; i++)
                for (int j = 0; j < rooms[0].length; j++)
                    if (rooms[i][j] == 0) search(rooms, i, j, 0);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WallsandGates().new Solution();
            int[][] grid = new int[][]{
                    new int[]{2147483647, -1, 0, 2147483647},
                    new int[]{2147483647, 2147483647, 2147483647, -1},
                    new int[]{2147483647, -1, 2147483647, -1},
                    new int[]{0, -1, 2147483647, 2147483647}
            };
            sol.wallsAndGates(grid);
            assertArrayEquals(new int[]{3, -1, 0, 1}, grid[0]);
            assertArrayEquals(new int[]{2, 2, 1, -1}, grid[1]);
            assertArrayEquals(new int[]{1, -1, 2, -1}, grid[2]);
            assertArrayEquals(new int[]{0, -1, 3, 4}, grid[3]);
        }

        @Test
        public void test2() {
            Solution_2 sol = new WallsandGates().new Solution_2();
            int[][] grid = new int[][]{
                    new int[]{2147483647, -1, 0, 2147483647},
                    new int[]{2147483647, 2147483647, 2147483647, -1},
                    new int[]{2147483647, -1, 2147483647, -1},
                    new int[]{0, -1, 2147483647, 2147483647}
            };
            sol.wallsAndGates(grid);
            assertArrayEquals(new int[]{3, -1, 0, 1}, grid[0]);
            assertArrayEquals(new int[]{2, 2, 1, -1}, grid[1]);
            assertArrayEquals(new int[]{1, -1, 2, -1}, grid[2]);
            assertArrayEquals(new int[]{0, -1, 3, 4}, grid[3]);
        }
    }
}
