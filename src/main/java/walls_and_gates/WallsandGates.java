package walls_and_gates;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class WallsandGates {
    /*
        Walls and Gates BFS
        http://buttercola.blogspot.com/2015/09/leetcode-walls-and-gates.html
        Difficulty: Medium
     */
    public class Solution {
        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0) {
                return;
            }

            int m = rooms.length;
            int n = rooms[0].length;

            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) {
                        wallsAndGatesHelper(i, j, 0, visited, rooms);
                    }
                }
            }
        }

        private void wallsAndGatesHelper(int row, int col, int distance, boolean[][] visited, int[][] rooms) {
            int rows = rooms.length;
            int cols = rooms[0].length;

            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                return;
            }

            // visited
            if (visited[row][col]) {
                return;
            }

            // Is wall?
            if (rooms[row][col] == -1) {
                return;
            }

            // Distance greater than current
            if (distance > rooms[row][col]) {
                return;
            }


            // Mark as visited
            visited[row][col] = true;

            if (distance < rooms[row][col]) {
                rooms[row][col] = distance;
            }

            // go up, down, left and right
            wallsAndGatesHelper(row - 1, col, distance + 1, visited, rooms);
            wallsAndGatesHelper(row + 1, col, distance + 1, visited, rooms);
            wallsAndGatesHelper(row, col - 1, distance + 1, visited, rooms);
            wallsAndGatesHelper(row, col + 1, distance + 1, visited, rooms);

            // Mark as unvisited
            visited[row][col] = false;
        }
    }

    /*
    Walls and Gates DFS
    http://buttercola.blogspot.com/2015/09/leetcode-walls-and-gates.html
    Difficulty: Medium
 */
    public class SolutionII {
        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0) {
                return;
            }

            int m = rooms.length;
            int n = rooms[0].length;

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) {
                        wallsAndGatesHelper(i, j, 0, rooms, queue);
                    }
                }
            }
        }

        private void wallsAndGatesHelper(int row, int col, int distance, int[][] rooms, Queue<Integer> queue) {
            fill(row, col, distance, rooms, queue);

            int m = rooms.length;
            int n = rooms[0].length;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cord = queue.poll();
                    int x = cord / n;
                    int y = cord % n;

                    fill(x - 1, y, distance + 1, rooms, queue);
                    fill(x + 1, y, distance + 1, rooms, queue);
                    fill(x, y - 1, distance + 1, rooms, queue);
                    fill(x, y + 1, distance + 1, rooms, queue);

                }
                distance++;
            }
        }

        private void fill (int row, int col, int distance, int[][] rooms, Queue<Integer> queue) {
            int m = rooms.length;
            int n = rooms[0].length;

            if (row < 0 || row >= m || col < 0 || col >= n) {
                return;
            }

            if (rooms[row][col] == -1) {
                return;
            }

            if (distance > rooms[row][col]) {
                return;
            }

            if (distance < rooms[row][col]) {
                rooms[row][col] = distance;
            }

            int cord = row * n + col;
            queue.offer(cord);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WallsandGates().new Solution();
        }
    }
}
