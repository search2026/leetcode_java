package graph_valid_tree;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GraphValidTree {
    /*
        Graph Valid Tree - DFS
        Leetcode #261
        https://leetcode.com/discuss/questions/oj/graph-valid-tree?sort=votes
        http://buttercola.blogspot.com/2015/08/leetcode-graph-valid-tree.html
        Difficulty: Medium
     */
    public class Solution {
        private boolean hasCycle(List<List<Integer>> adj, int cur, HashSet<Integer> visited, int parent) {
            visited.add(cur);

            for (int i = 0; i < adj.get(cur).size(); i++) {
                int neighbor = adj.get(cur).get(i);
                if ((visited.contains(neighbor) && parent != neighbor) ||
                        (!visited.contains(neighbor) && hasCycle(adj, neighbor, visited, cur)))
                    return true;
            }

            return false;
        }

        public boolean validTree(int n, int[][] edges) {
            List<List<Integer>> adj = new ArrayList<List<Integer>>(n);
            for (int i = 0; i < n; i++)
                adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0], v = edges[i][1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            HashSet<Integer> visited = new HashSet<Integer>();
            if (hasCycle(adj, 0, visited, -1))
                return false;

            // checks if there is an isolated island
            return visited.size() == n;
        }
    }

    /*
        Graph Valid Tree - BFS
        Leetcode #261
        https://leetcode.com/discuss/questions/oj/graph-valid-tree?sort=votes
        http://buttercola.blogspot.com/2015/08/leetcode-graph-valid-tree.html
        Difficulty: Medium
     */
    public class Solution_2 {
        public boolean validTree(int n, int[][] edges) {
            List<Set<Integer>> graph = new ArrayList<Set<Integer>>();

            for (int i = 0; i < n; i++) {
                graph.add(i, new HashSet<Integer>());
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            HashSet<Integer> visited = new HashSet<Integer>();
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(0);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (visited.contains(cur)) return false;
                visited.add(cur);
                for (int neighbor : graph.get(cur)) {
                    if (!visited.contains(neighbor))
                        queue.offer(neighbor);
                }
            }

            // checks if there is an isolated island
            return visited.size() == n;
        }
    }

    /*
        Graph Valid Tree - Union & Find
        Leetcode #261
        https://leetcode.com/discuss/questions/oj/graph-valid-tree?sort=votes
        http://buttercola.blogspot.com/2015/08/leetcode-graph-valid-tree.html
        Difficulty: Medium
    */
    public class Solution_3 {
        public boolean validTree(int n, int[][] edges) {
            int[] root = new int[n];
            for (int i=0; i<n;i++)
                root[i] = i;

            for (int[] edge : edges) {
                int x = findRoot(root, edge[0]);
                int y = findRoot(root, edge[1]);
                // if two vertices are in the same set, there's a cycle
                if (x == y) return false;
                // union
                root[x] = y;
            }

            return edges.length == n - 1;
        }

        public int findRoot(int root[], int n) {
            while (root[n] != n) n = root[n];
            return n;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new GraphValidTree().new Solution();
            int n = 5;
            int[][] edges = new int[][]{
                    new int[]{0, 1},
                    new int[]{0, 2},
                    new int[]{0, 3},
                    new int[]{1, 4}
            };
            assertTrue(sol.validTree(n, edges));

            n = 5;
            edges = new int[][]{
                    new int[]{0, 1},
                    new int[]{1, 2},
                    new int[]{2, 3},
                    new int[]{1, 3},
                    new int[]{1, 4}
            };
            assertFalse(sol.validTree(n, edges));
        }

        @Test
        public void test2() {
            Solution_2 sol = new GraphValidTree().new Solution_2();
            int n = 5;
            int[][] edges = new int[][]{
                    new int[]{0, 1},
                    new int[]{0, 2},
                    new int[]{0, 3},
                    new int[]{1, 4}
            };
            assertTrue(sol.validTree(n, edges));

            n = 5;
            edges = new int[][]{
                    new int[]{0, 1},
                    new int[]{1, 2},
                    new int[]{2, 3},
                    new int[]{1, 3},
                    new int[]{1, 4}
            };
            assertFalse(sol.validTree(n, edges));
        }

        @Test
        public void test3() {
            Solution_3 sol = new GraphValidTree().new Solution_3();
            int n = 5;
            int[][] edges = new int[][]{
                    new int[]{0, 1},
                    new int[]{0, 2},
                    new int[]{0, 3},
                    new int[]{1, 4}
            };
            assertTrue(sol.validTree(n, edges));

            n = 5;
            edges = new int[][]{
                    new int[]{0, 1},
                    new int[]{1, 2},
                    new int[]{2, 3},
                    new int[]{1, 3},
                    new int[]{1, 4}
            };
            assertFalse(sol.validTree(n, edges));
        }
    }
}
