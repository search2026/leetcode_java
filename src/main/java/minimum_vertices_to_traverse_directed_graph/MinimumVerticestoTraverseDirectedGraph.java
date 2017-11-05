package minimum_vertices_to_traverse_directed_graph;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MinimumVerticestoTraverseDirectedGraph {
    /*
        Minimum Vertices to Traverse Directed Graph
        https://cs.stackexchange.com/questions/1698/find-the-minimal-number-of-runs-to-visit-every-edge-of-a-directed-graph
        Difficulty: Hard
     */
    public class Solution {
        private void dfs(Set<Integer> res, Map<Integer, Set<Integer>> nodes, int cur, int start,
                         Set<Integer> visited, Set<Integer> thisTimeVisited) {
            for (int next : nodes.get(cur)) {
                if (res.contains(next) && next != start) {
                    res.remove(next);
                }
                if (!thisTimeVisited.contains(next)) {
                    thisTimeVisited.add(next);
                    visited.add(next);
                    dfs(res, nodes, next, start, visited, thisTimeVisited);
                }
            }
        }

        public List<Integer> getMin(int[][] edges, int n) {
            Set<Integer> res = new HashSet<>();

            Map<Integer, Set<Integer>> nodes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                nodes.put(i, new HashSet<>());
            }
            for (int[] edge : edges) {
                nodes.get(edge[0]).add(edge[1]);
            }

            Set<Integer> visited = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (visited.contains(i)) {
                    continue;
                }

                res.add(i);
                visited.add(i);
                Set<Integer> thisTimeVisited = new HashSet<>();
                dfs(res, nodes, i, i, visited, thisTimeVisited);
            }

            return new ArrayList<>(res);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MinimumVerticestoTraverseDirectedGraph().new Solution();
            int[][] edges1 = {{0, 0}, {1, 2}, {2, 0}, {2, 3}, {3, 1}};
            ////      0  1  2  3  4  5  6  7  8  9
            ////    0[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            ////    1[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            ////    2[0, 0, 0 ,0, 0, 0, 0, 0, 0, 1]
            ////    3[0, 0, 0, 1, 0, 1, 0, 1, 0, 0]
            ////    4[0, 0, 0, 0, 0, 0 ,0, 0, 1, 0]
            ////    5[0, 0, 0, 0, 0, 0, 0, 0, 1, 0]
            ////    6[0, 0, 0, 0, 0, 0, 1, 0, 0 ,0]
            ////    7[0, 0, 0, 0, 1, 0, 0, 0, 0, 0]
            ////    8[0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
            ////    9[0, 0, 0, 1, 0, 0, 1, 0, 0, 0]
            int[][] edges2 = {{2, 9}, {3, 3}, {3, 5}, {3, 7}, {4, 8}, {5, 8}, {6, 6}, {7, 4}, {8, 7}, {9, 3}, {9, 6}};
            int[][] edges3 = {{0, 1}, {1, 0}, {2, 1}, {2, 3}, {3, 2}};
            List<Integer> res = sol.getMin(edges3, 4);
            assertEquals(1, res.size());
        }        
    }
}

