package graph_valid_tree;

import java.util.*;

public class GraphValidTree {
    /*
        Graph Valid Tree DFS
        http://buttercola.blogspot.com/2015/08/leetcode-graph-valid-tree.html
        Difficulty: Medium
     */
    public class Solution {
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

            if (!validTreeHelper(n, edges, 0, -1, visited, adjList)) {
                return false;
            }

            // Check the islands
            for (boolean v : visited) {
                if (!v) {
                    return false;
                }
            }

            return true;
        }

        private boolean validTreeHelper(int n, int[][] edges, int vertexId, int parentId,
                                        boolean[] visited, List<List<Integer>> adjList) {
            if (visited[vertexId]) {
                return false;
            }

            visited[vertexId] = true;

            List<Integer> neighbors = adjList.get(vertexId);
            for (Integer neighbor : neighbors) {
                if (neighbor != parentId && !validTreeHelper(n, edges, neighbor, vertexId, visited, adjList)) {
                    return false;
                }
            }

            return true;
        }
    }

    /*
        Graph Valid Tree BFS
        http://buttercola.blogspot.com/2015/08/leetcode-graph-valid-tree.html
        Difficulty: Medium
     */
    public class SolutionII {
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

    public static class UnitTest {

    }
}
