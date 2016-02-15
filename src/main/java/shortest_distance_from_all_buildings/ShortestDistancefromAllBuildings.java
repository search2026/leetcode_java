package shortest_distance_from_all_buildings;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

//import org.apache.commons.lang3.tuple.Pair;

public class ShortestDistancefromAllBuildings {
    /*
        Shortest Distance From All Building
        http://www.cnblogs.com/EdwardLiu/p/5094091.html
        Difficulty: Hard
     */
    public class Solution {
        public int shortestDistance(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
            int m = grid.length;
            int n = grid[0].length;
            int[][] dist = new int[m][n];
            int[][] reach = new int[m][n];
            int houseNum = 0;
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        houseNum++;
                        int level = 0;
                        boolean[][] visited = new boolean[m][n];
                        Queue<Integer> queue = new ArrayDeque<Integer>();
                        queue.offer(i * n + j);
                        visited[i][j] = true;
                        while (!queue.isEmpty()) {
                            int size = queue.size();
                            for (int t = 0; t < size; t++) {
                                int cur = queue.poll();
                                int x = cur / n;
                                int y = cur % n;
                                for (int[] dir : dirs) {
                                    int newX = x + dir[0];
                                    int newY = y + dir[1];
                                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] == 0) {
                                        queue.offer(newX * n + newY);
                                        visited[newX][newY] = true;
                                        dist[newX][newY] += level + 1;
                                        reach[newX][newY]++;
                                    }
                                }
                            }
                            level++;
                        }
                    }
                }
            }

            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0 && reach[i][j] == houseNum) {
                        minDist = Math.min(minDist, dist[i][j]);
                    }
                }
            }
            return minDist == Integer.MAX_VALUE ? -1 : minDist;
        }
    }

    /*
        Shortest Distance From All Building
        https://leetcode.com/discuss/questions/oj/shortest-distance-from-all-buildings
        Difficulty: Hard
     */
    public class Solution_2 {
        public int shortestDistance(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
            int m = grid.length;
            int n = grid[0].length;
            int[][] dist = new int[m][n];
            int count = 0;
            int[][] reach = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        count++;
                        search(grid, dist, reach, i, j);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0 && reach[i][j] == count) {
                        min = Math.min(min, dist[i][j]);
                    }
                }
            }
            if (min == Integer.MAX_VALUE) return -1;
            return min;
        }

        public void search(int[][] grid, int[][] dist, int[][] reach, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> queue = new ArrayDeque<int[]>();
            queue.offer(new int[]{i, j});
            boolean[][] visited = new boolean[m][n];
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int[][] cur_dist = new int[m][n];
            int step = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int a = 0; a < size; a++) {
                    int[] cur = queue.poll();
                    for (int[] dir : dirs) {
                        int newX = cur[0] + dir[0];
                        int newY = cur[1] + dir[1];
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0 && !visited[newX][newY]) {
                            cur_dist[newX][newY] = step;
                            reach[newX][newY]++;
                            visited[newX][newY] = true;
                            queue.offer(new int[]{newX, newY});
                            dist[newX][newY] += cur_dist[newX][newY];
                        }
                    }
                }
                step++;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ShortestDistancefromAllBuildings().new Solution();
            int[][] test = new int[][]{
                    new int[]{1, 0, 2, 0, 1},
                    new int[]{0, 0, 0, 0, 0},
                    new int[]{0, 0, 1, 0, 0}
            };

            assertEquals(7, sol.shortestDistance(test));
        }

        @Test
        public void test2() {
            Solution_2 sol = new ShortestDistancefromAllBuildings().new Solution_2();
            int[][] test = new int[][]{
                    new int[]{1, 0, 2, 0, 1},
                    new int[]{0, 0, 0, 0, 0},
                    new int[]{0, 0, 1, 0, 0}
            };

            assertEquals(7, sol.shortestDistance(test));
        }
    }
}
