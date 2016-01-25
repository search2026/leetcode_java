package walls_and_gates;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.junit.Assert.*;

public class WallsandGates {
    /*
        Walls and Gates - BFS
        http://www.cnblogs.com/EdwardLiu/p/5077950.html
        Difficulty: Medium
     */
    public class Solution {
        private void search(int[][] rooms, int i, int j) {
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(i * rooms[0].length + j);
            int dist = 0;
            Set<Integer> visited = new HashSet<Integer>();
            visited.add(i * rooms[0].length + j);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    Integer curr = queue.poll();
                    int row = curr / rooms[0].length;
                    int col = curr % rooms[0].length;

                    rooms[row][col] = Math.min(rooms[row][col], dist);
                    int up = (row - 1) * rooms[0].length + col;
                    int down = (row + 1) * rooms[0].length + col;
                    int left = row * rooms[0].length + col - 1;
                    int right = row * rooms[0].length + col + 1;

                    if (row > 0 && rooms[row - 1][col] > 0 && !visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    if (col > 0 && rooms[row][col - 1] > 0 && !visited.contains(left)) {
                        queue.offer(left);
                        visited.add(left);
                    }
                    if (row < rooms.length - 1 && rooms[row + 1][col] > 0 && !visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                    if (col < rooms[0].length - 1 && rooms[row][col + 1] > 0 && !visited.contains(right)) {
                        queue.offer(right);
                        visited.add(right);
                    }
                }
                dist++;
            }
        }

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0) return;
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[0].length; j++) {
                    if (rooms[i][j] == 0) search(rooms, i, j);
                }
            }
        }
    }

    /*
        Walls and Gates - DFS
        http://buttercola.blogspot.com/2015/09/leetcode-walls-and-gates.html
        Difficulty: Medium
     */
    public class Solution_2 {
        private void fill(int row, int col, int distance, int[][] rooms, Queue<Integer> queue) {
            int m = rooms.length;
            int n = rooms[0].length;

            if (row < 0 || row >= m || col < 0 || col >= n) return;
            if (rooms[row][col] == -1) return;
            if (distance > rooms[row][col]) return;
            if (distance < rooms[row][col]) rooms[row][col] = distance;

            int cord = row * n + col;
            queue.offer(cord);
        }

        private void search(int row, int col, int distance, int[][] rooms, Queue<Integer> queue) {
            fill(row, col, distance, rooms, queue);

            int m = rooms.length;
            int n = rooms[0].length;
            int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cord = queue.poll();
                    int x = cord / n;
                    int y = cord % n;

                    for(int[] dir: directions){
                         fill(x+dir[0], y+dir[1], distance + 1, rooms, queue);
                    }
                }
                distance++;
            }
        }

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0) return;
            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[0].length; j++) {
                    if (rooms[i][j] == 0) search(i, j, 0, rooms, queue);
                }
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WallsandGates().new Solution();
            int[][] grid = new int[][]{
                new int[]{2147483647, -1, 0, 2147483647},
                new int[]{2147483647,2147483647,2147483647,-1},
                    new int[]{2147483647,-1,2147483647,-1},
                    new int[]{0,-1,2147483647,2147483647}
            };
            sol.wallsAndGates(grid);
            assertArrayEquals(new int[]{3,-1,0,1},grid[0]);
            assertArrayEquals(new int[]{2,2,1,-1},grid[1]);
            assertArrayEquals(new int[]{1,-1,2,-1},grid[2]);
            assertArrayEquals(new int[]{0,-1,3,4},grid[3]);
        }

        @Test
        public void test2() {
            Solution_2 sol = new WallsandGates().new Solution_2();
            int[][] grid = new int[][]{
                    new int[]{2147483647, -1, 0, 2147483647},
                    new int[]{2147483647,2147483647,2147483647,-1},
                    new int[]{2147483647,-1,2147483647,-1},
                    new int[]{0,-1,2147483647,2147483647}
            };
            sol.wallsAndGates(grid);
            assertArrayEquals(new int[]{3,-1,0,1},grid[0]);
            assertArrayEquals(new int[]{2,2,1,-1},grid[1]);
            assertArrayEquals(new int[]{1,-1,2,-1},grid[2]);
            assertArrayEquals(new int[]{0,-1,3,4},grid[3]);
        }
    }
}
