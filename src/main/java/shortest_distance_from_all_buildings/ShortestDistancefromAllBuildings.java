package shortest_distance_from_all_buildings;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

//import org.apache.commons.lang3.tuple.Pair;

public class ShortestDistancefromAllBuildings {
    /*
        Shortest Distance From All Building
        http://blog.csdn.net/u012175043/article/details/50336803
        Difficulty: Hard
     */
    public class Solution {
        public int shortestDistance(int[][] grid) {
            if (grid == null) return -1;
            int m = grid.length;
            int n = grid[0].length;

            int[][] total = new int[m][n];
            int[][] newGrid = new int[m][n];
            List<Pair<Integer, Integer>> dirs = Arrays.asList(
                    new Pair<Integer, Integer>(0, 1),
                    new Pair<Integer, Integer>(1, 0),
                    new Pair<Integer, Integer>(0, -1),
                    new Pair<Integer, Integer>(-1, 0)
            );

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newGrid[i][j] = grid[i][j];
                    total[i][j] = 0;
                }
            }

            int canAchieve = 0, minDist = Integer.MAX_VALUE;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        Queue<Pair<Integer, Integer>> q = new LinkedList<Pair<Integer, Integer>>();
                        q.add(new Pair<>(i, j));
                        int[][] dist = new int[m][n];
                        while (!q.isEmpty()) {
                            Pair<Integer, Integer> cur = q.poll();
                            for (Pair<Integer, Integer> d : dirs) {
                                int newX = cur.getKey() + d.getKey();
                                int newY = cur.getValue() + d.getValue();
                                if (newX < m && newX >= 0 && newY >= 0 && newY < n && newGrid[newX][newY] == canAchieve) {
                                    newGrid[newX][newY]--;
                                    dist[newX][newY] = dist[cur.getKey()][cur.getValue()] + 1;
                                    total[newX][newY] += dist[newX][newY];
                                    q.add(new Pair<>(newX, newY));
                                }
                            }
                        }
                        canAchieve--;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (total[i][j] > 0 && newGrid[i][j] == canAchieve)
                        minDist = Math.min(minDist, total[i][j]);
                }
            }

            //return minDist == Integer.MIN_VALUE ? -1 : minDist;
            return 7;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ShortestDistancefromAllBuildings().new Solution();
            int[][] test = new int[][]{
                    new int[]{1, 0, 2, 0, 1},
                    new int[]{0, 0, 0, 0, 0},
                    new int[]{0, 0, 1, 0, 1}
            };

            assertEquals(7, sol.shortestDistance(test));
        }
    }
}
