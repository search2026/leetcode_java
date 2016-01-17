package number_of_islands;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NumberofIslands {
    /*
        Number of Islands
        https://leetcode.com/problems/number-of-islands/
        Difficulty: Medium
    */
    public class Solution {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        floodFill(grid, i, j);
                    }
                }
            }
            return count;
        }

        public void floodFill(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
                return;

            if (grid[i][j] != '1') return;

            grid[i][j] = '2'; // set visited island to 2

            for (int[] dir : dirs) {
                floodFill(grid, i + dir[0], j + dir[1]);
            }
        }
    }

    /*
        Find connected island
        http://www.elvisyu.com/leetcode-number-of-islands/
        Difficulty: Medium
    */
    public class Solution_2 {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

        private void findAdjacentIsland(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != 0) {
                        map.put(grid[i][j], new HashSet<Integer>());
                        merge(grid, i, j, grid[i][j]);
                    }
                }
            }
        }

        private void merge(int[][] grid, int i, int j, int islandNumber) {
            if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
                return;
            }
            if (grid[i][j] == 0)
                return;
            if (grid[i][j] != 0 && grid[i][j] != islandNumber) {
                map.get(islandNumber).add(grid[i][j]);
                return;
            }
            grid[i][j] = 0; // set visited island to 0
            merge(grid, i - 1, j, islandNumber);
            merge(grid, i + 1, j, islandNumber);
            merge(grid, i, j + 1, islandNumber);
            merge(grid, i, j - 1, islandNumber);
            grid[i][j] = islandNumber;
        }
    }

    /*
        Number of Islands II - Union Find
        http://www.cnblogs.com/EdwardLiu/p/5087633.html
        Difficulty: Hard
    */
    public class Solution_3 {
        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            unionFind uf = new unionFind(m * n);
            List<Integer> rslt = new ArrayList<Integer>();
            for (int[] pos : positions) {
                int cur = pos[0] * n + pos[1];
                uf.ids[cur] = cur;
                uf.count++;
                for (int[] dir : dirs) {
                    int x = dir[0] + pos[0];
                    int y = dir[1] + pos[1];
                    int nb = x * n + y;
                    if (x < 0 || x >= m || y < 0 || y >= n || uf.ids[nb] == -1) continue;
                    if (uf.find(nb) != uf.find(cur)) {
                        uf.union(nb, cur);
                    }
                }
                rslt.add(uf.count);
            }
            return rslt;
        }

        public class unionFind {
            int[] ids;
            int count;

            public unionFind(int num) {
                this.ids = new int[num];
                Arrays.fill(ids, -1);
                this.count = 0;
            }

            public int find(int num) {
                return ids[num];
            }

            public boolean union(int n1, int n2) {
                int id1 = ids[n1], id2 = ids[n2];
                if (id1 != id2) {
                    for (int i = 0; i < ids.length; i++) {
                        if (ids[i] == id2) {
                            ids[i] = id1;
                        }
                    }
                    count--;
                    return true;
                }
                return false;
            }
        }
    }

    /*
      Number of Islands II - Union Find
      http://www.cnblogs.com/EdwardLiu/p/5087633.html
      Difficulty: Hard
  */
    public class Solution_4 {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            List<Integer> rslt = new ArrayList<Integer>();
            if (m <= 0 || n <= 0) return rslt;

            int count = 0;                      // number of islands
            int[] roots = new int[m * n];       // one island = one tree
            Arrays.fill(roots, -1);

            for (int[] p : positions) {
                int root = n * p[0] + p[1];     // assume new point is isolated island
                roots[root] = root;             // add new island
                count++;

                for (int[] dir : dirs) {
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    int nb = n * x + y;
                    if (x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;

                    int rootNb = findIsland(roots, nb);
                    if (roots[root] != rootNb) { // if neighbor is in another island
                        roots[root] = rootNb; // union two islands
                        root = rootNb; // current tree root = joined tree root
                        count--;
                    }
                }

                rslt.add(count);
            }
            return rslt;
        }

        public int findIsland(int[] roots, int id) {
            while (id != roots[id]) id = roots[id];
            return id;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new NumberofIslands().new Solution();
            char[][] island = new char[][]{
                    new char[]{'1', '1', '0', '0', '0'},
                    new char[]{'1', '1', '0', '0', '0'},
                    new char[]{'0', '0', '1', '0', '0'},
                    new char[]{'0', '0', '0', '1', '1'}
            };
            assertEquals(3, sol.numIslands(island));
            assertTrue(true);
        }
    }
}
