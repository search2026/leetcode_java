package number_of_islands;

import common.UnionFind2D;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberofIslands {
    /*
        Number of Islands - Flood Fill
        Leetcode #200
        https://leetcode.com/problems/number-of-islands/
        Difficulty: Medium
    */
    public class Solution {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public void floodFill(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
                return;
            if (grid[i][j] != '1') return;

            grid[i][j] = '2'; // set visited island to 2
            for (int[] dir : dirs)
                floodFill(grid, i + dir[0], j + dir[1]);
        }

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
    }

    /*
        Number of Islands - Union-Find
        Leetcode #200
        https://leetcode.com/problems/number-of-islands/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int numIslands(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            int m = grid.length, n = grid[0].length;
            UnionFind uf = new UnionFind(m, n, grid);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '0') continue;
                    int p = i * n + j;
                    int q;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        q = p - n;
                        uf.union(p, q);
                    }
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        q = p + n;
                        uf.union(p, q);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        q = p - 1;
                        uf.union(p, q);
                    }
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        q = p + 1;
                        uf.union(p, q);
                    }
                }
            }
            return uf.count;
        }

        class UnionFind {
            public int count = 0;
            public int[] id = null;

            public UnionFind(int m, int n, char[][] grid) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == '1') count++;
                    }
                }
                id = new int[m * n];
                for (int i = 0; i < m * n; i++) {
                    id[i] = i;
                }
            }

            public int find(int p) {
                while (p != id[p]) {
                    id[p] = id[id[p]];
                    p = id[p];
                }
                return p;
            }

            public boolean isConnected(int p, int q) {
                int pRoot = find(p);
                int qRoot = find(q);
                if (pRoot != qRoot) return false;
                else return true;
            }

            public void union(int p, int q) {
                int pRoot = find(p);
                int qRoot = find(q);
                if (pRoot == qRoot) return;
                id[pRoot] = qRoot;
                count--;
            }

        }
    }

    /*
        Find Connected Islands
        http://www.elvisyu.com/leetcode-number-of-islands/
        Difficulty: Medium
    */
    public class Solution_3 {
        Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        private void merge(int[][] grid, int i, int j, int islandNumber) {
            if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
                return;
            if (grid[i][j] == 0) return;
            if (grid[i][j] != 0 && grid[i][j] != islandNumber) {
                adj.get(islandNumber).add(grid[i][j]);
                return;
            }
            grid[i][j] = 0; // set visited island to 0
            for (int[] dir : dirs)
                merge(grid, i + dir[0], j + dir[1], islandNumber);
            grid[i][j] = islandNumber;
        }

        private void findAdjacentIsland(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != 0) {
                        adj.put(grid[i][j], new HashSet<Integer>());
                        merge(grid, i, j, grid[i][j]);
                    }
                }
            }
        }
    }

    /*
      Number of Islands II - Union Find
      Leetcode #305
      https://leetcode.com/discuss/questions/oj/number-of-islands-ii?sort=votes
      http://www.cnblogs.com/EdwardLiu/p/5087633.html
      Difficulty: Hard
    */
    public class Solution_4 {
        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            List<Integer> res = new ArrayList<>();
            if (m <= 0 || n <= 0) return res;

            int count = 0;
            int[] root = new int[m * n];
            Arrays.fill(root, -1);
            int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

            for (int[] p : positions) {
                int point = n * p[0] + p[1];
                root[point] = point;
                count++;

                for (int[] dir : dirs) {
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    int neighbor = n * x + y;
                    if (x < 0 || x >= m || y < 0 || y >= n || root[neighbor] == -1) continue;

                    int n_root = findRoot(root, neighbor);
                    if (root[point] != n_root) {
                        root[point] = n_root;
                        point = n_root;
                        count--;
                    }
                }

                res.add(count);
            }
            return res;
        }

        private int findRoot(int[] root, int n) {
            while (n != root[n]) n = root[n];
            return n;
        }
    }

    /*
      Number of Islands II - Union Find
      Leetcode #305
      https://leetcode.com/discuss/questions/oj/number-of-islands-ii?sort=votes
      http://www.cnblogs.com/EdwardLiu/p/5087633.html
      Difficulty: Hard
    */
    public class Solution_5 {
        private int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            UnionFind2D islands = new UnionFind2D(m, n);
            List<Integer> res = new ArrayList<>();
            for (int[] position : positions) {
                int x = position[0], y = position[1];
                int p = islands.add(x, y);
                for (int[] d : dir) {
                    int q = islands.getID(x + d[0], y + d[1]);
                    if (q > 0 && !islands.find(p, q))
                        islands.unite(p, q);
                }
                res.add(islands.size());
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new NumberofIslands().new Solution();
            char[][] island = new char[][]{
                    new char[]{'1', '1', '1', '1', '0'},
                    new char[]{'1', '1', '0', '1', '0'},
                    new char[]{'1', '1', '1', '0', '0'},
                    new char[]{'0', '0', '0', '0', '0'}
            };
            assertEquals(1, sol.numIslands(island));

            island = new char[][]{
                    new char[]{'1', '1', '0', '0', '0'},
                    new char[]{'1', '1', '0', '0', '0'},
                    new char[]{'0', '0', '1', '0', '0'},
                    new char[]{'0', '0', '0', '1', '1'}
            };
            assertEquals(3, sol.numIslands(island));
        }

        @Test
        public void test2() {
            Solution_2 sol = new NumberofIslands().new Solution_2();
            char[][] island = new char[][]{
                    new char[]{'1', '1', '1', '1', '0'},
                    new char[]{'1', '1', '0', '1', '0'},
                    new char[]{'1', '1', '1', '0', '0'},
                    new char[]{'0', '0', '0', '0', '0'}
            };
            assertEquals(1, sol.numIslands(island));

            island = new char[][]{
                    new char[]{'1', '1', '0', '0', '0'},
                    new char[]{'1', '1', '0', '0', '0'},
                    new char[]{'0', '0', '1', '0', '0'},
                    new char[]{'0', '0', '0', '1', '1'}
            };
            assertEquals(3, sol.numIslands(island));
        }

        @Test
        public void test4() {
            Solution_4 sol = new NumberofIslands().new Solution_4();

            int[][] positions = new int[][]{
                    {0, 0},
                    {0, 1},
                    {1, 2},
                    {2, 1}
            };
            // positions[0][0] = 1;
            List<Integer> res = sol.numIslands2(3, 3, positions);

            assertEquals(positions.length, res.size());
            assertEquals(1, (int)res.get(0));
            assertEquals(1, (int)res.get(1));
            assertEquals(2, (int)res.get(2));
            assertEquals(3, (int)res.get(3));
        }

        @Test
        public void test5() {
            Solution_5 sol = new NumberofIslands().new Solution_5();

            int[][] positions = new int[][]{
                    {0, 0},
                    {0, 1},
                    {1, 2},
                    {2, 1}
            };
            // positions[0][0] = 1;
            List<Integer> res = sol.numIslands2(3, 3, positions);

            assertEquals(positions.length, res.size());
            assertEquals(1, (int)res.get(0));
            assertEquals(1, (int)res.get(1));
            assertEquals(2, (int)res.get(2));
            assertEquals(3, (int)res.get(3));
        }
    }
}
