package com.search2026.leetcode.problems;

import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    /*
        Number of Connected Components in an Undirected Graph - BFS/DFS
        Leetcode #323
        https://github.com/search2026/leetcode_java/blob/master/resources/NumberOfConnectedComponentsInAnUndirectedGraph.md
        Difficulty: Medium
     */
    public class Solution {
        public int countComponents(int n, int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] item : edges) {
                graph.get(item[1]).add(item[0]);
                graph.get(item[0]).add(item[1]);
            }

            HashSet<Integer> visited = new HashSet<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    count++;
                    // search(i, graph, visited);
                    bfs(graph, i, visited);
                }
            }
            return count;
        }

        public void bfs(List<List<Integer>> graph, int i, HashSet<Integer> visited) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int neighbor : graph.get(cur)) {
                    if (!visited.contains(neighbor)) {
                        q.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }

        public void dfs(int i, List<List<Integer>> graph, HashSet<Integer> visited) {
            visited.add(i);
            for (int num : graph.get(i)) {
                if (!visited.contains(num)) {
                    dfs(num, graph, visited);
                }
            }
        }
    }

    /*
        Number of Connected Components in an Undirected Graph - Union Find
        Leetcode #323
        https://github.com/search2026/leetcode_java/blob/master/resources/NumberOfConnectedComponentsInAnUndirectedGraph.md
        Difficulty: Medium
     */
    public class Solution_2 {
        public int countComponents(int n, int[][] edges) {
            int[] root = new int[n];
            int count = n;

            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            for (int[] edge : edges) {
                int x = findRoot(root, edge[0]);
                int y = findRoot(root, edge[1]);
                if (x != y) {
                    root[x] = y;
                    count--;
                }
            }
            return count;
        }

        public int findRoot(int[] root, int n) {
            while (root[n] != n) n = root[n];
            return n;
        }
    }

    /*
        Number of Connected Components in an Undirected Graph
        Leetcode #323
        https://github.com/search2026/leetcode_java/blob/master/resources/NumberOfConnectedComponentsInAnUndirectedGraph.md
        Difficulty: Medium
     */
    public class Solution_3 {
        public int countComponents(int n, int[][] edges) {
            unionFind uf = new unionFind(n);
            for (int[] edge : edges) {
                if (!uf.isConnected(edge[0], edge[1])) {
                    uf.union(edge[0], edge[1]);
                }
            }
            return uf.findCount();
        }

        public class unionFind {
            int[] ids;
            int count;

            public unionFind(int num) {
                this.ids = new int[num];
                for (int i = 0; i < num; i++) {
                    ids[i] = i;
                }
                this.count = num;
            }

            private int find(int i) {
                return ids[i];
            }

            public void union(int i1, int i2) {
                int id1 = find(i1);
                int id2 = find(i2);
                if (id1 != id2) {
                    for (int i = 0; i < ids.length; i++) {
                        if (ids[i] == id2) {
                            ids[i] = id1;
                        }
                    }
                    count--;
                }
            }

            public boolean isConnected(int i1, int i2) {
                return find(i1) == find(i2);
            }

            public int findCount() {
                return count;
            }
        }
    }

}
