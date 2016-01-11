package graph_valid_tree;

import java.util.*;

public class GraphValidTree {
    /*
        Graph Valid Tree - DFS
        http://buttercola.blogspot.com/2015/08/leetcode-graph-valid-tree.html
        Difficulty: Medium
     */
    public class Solution {
        public boolean validTree(int n, int[][] edges) {
            // initialize adjacency list
            List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);

            // initialize vertices
            for (int i = 0; i < n; i++)
                adjList.add(i, new ArrayList<Integer>());

            // update edges
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0], v = edges[i][1];
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            boolean[] visited = new boolean[n];

            // make sure there's no cycle
            if (hasCycle(adjList, 0, visited, -1))
                return false;

            // make sure all vertices are connected. check the islands.
            for (int i = 0; i < n; i++) {
                if (!visited[i])
                    return false;
            }

            return true;
        }

        // check if an undirected graph has cycle started from vertex u
        boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
            visited[u] = true;

            for (int i = 0; i < adjList.get(u).size(); i++) {
                int v = adjList.get(u).get(i);
                if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                    return true;
            }

            return false;
        }
    }

    /*
        Graph Valid Tree - BFS
        http://buttercola.blogspot.com/2015/08/leetcode-graph-valid-tree.html
        Difficulty: Medium
     */
    public class Solution_2 {
        public boolean validTree(int n, int[][] edges) {
            // Create an adj list
            List<List<Integer>> adjList = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<Integer>());
            }

            for (int[] edge : edges) {
                adjList.get(edge[1]).add(edge[0]);
                adjList.get(edge[0]).add(edge[1]);
            }

            boolean[] visited = new boolean[n];

            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(0);

            while (!queue.isEmpty()) {
                int vertexId = queue.poll();

                if (visited[vertexId]) {
                    return false;
                }

                visited[vertexId] = true;

                for (int neighbor : adjList.get(vertexId)) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                    }
                }
            }

            // Check the islands
            for (boolean v : visited) {
                if (!v) {
                    return false;
                }
            }

            return true;
        }
    }

    /*
        Graph Valid Tree - Union & Find
        http://buttercola.blogspot.com/2015/08/leetcode-graph-valid-tree.html
        Difficulty: Medium
    */
    public class Solution_3 {
        public boolean validTree(int n, int[][] edges) {
            // initialize n isolated islands
            int[] nums = new int[n];
            Arrays.fill(nums, -1);

            // perform union find
            for (int i = 0; i < edges.length; i++) {
                int x = find(nums, edges[i][0]);
                int y = find(nums, edges[i][1]);

                // if two vertices happen to be in the same set
                // then there's a cycle
                if (x == y) return false;

                // union
                nums[x] = y;
            }

            return edges.length == n - 1;
        }

        public int find(int nums[], int i) {
            if (nums[i] == -1) return i;
            // recursively search for parents
            return find(nums, nums[i]);
        }
    }

    public static class UnitTest {

    }
}
