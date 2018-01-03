package valid_bipartit_graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class ValidBipartitGraph {
    /*
        Valid Bipartit Graph
        http://www.geeksforgeeks.org/bipartite-graph/
        Difficulty: Medium
     */
    public class Solution {
        boolean isBipartite(int grid[][], int root) {
            if (grid == null || grid.length ==0 || grid[0] == null || grid[0].length == 0) return false;
            int n = grid[0].length;
            int colors[] = new int[n];
            Arrays.fill(colors, -1);
            colors[root] = 1;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(root);

            while (queue.size() != 0) {
                int cur = queue.poll();
                for (int v = 0; v < n; ++v) {
                    if (grid[cur][v] == 1 && colors[v] == -1) {
                        colors[v] = 1 - colors[cur];
                        queue.add(v);
                    } else if (grid[cur][v] == 1 && colors[v] == colors[cur])
                        return false;
                }
            }

            return true;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ValidBipartitGraph().new Solution();
            int grid[][] = {{0, 1, 0, 1},
                    {1, 0, 1, 0},
                    {0, 1, 0, 1},
                    {1, 0, 1, 0}
            };
            assertTrue(sol.isBipartite(grid, 0));
        }
    }
}

