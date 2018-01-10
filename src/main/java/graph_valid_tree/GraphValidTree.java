package graph_valid_tree;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GraphValidTree {
  /*
      Graph Valid Tree - DFS
      Leetcode #261
      https://leetcode.com/discuss/questions/oj/graph-valid-tree?sort=votes
      http://buttercola.blogspot.com/2015/08/leetcode-graph-valid-tree.html
      Difficulty: Medium
   */
  public class Solution {
    private boolean hasCycle(List<HashSet<Integer>> graph, Set<Integer> v, int curr, int prev) {
      v.add(curr);

      for (int nbr : graph.get(curr)) {
        if (v.contains(nbr)) {
          if (prev != nbr) return true;
        } else if (hasCycle(graph, v, nbr, curr)) return true;
      }

      return false;
    }

    public boolean validTree(int n, int[][] edges) {
      if (edges == null || edges.length == 0 || edges.length != n - 1 ||
              edges[0] == null || edges[0].length != 2) return false;

      List<HashSet<Integer>> graph = new ArrayList<>();
      for (int i = 0; i < n; i++) graph.add(new HashSet<Integer>());
      for (int[] edge : edges) {
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
      }

      Set<Integer> v = new HashSet<>();
      if (hasCycle(graph, v, 0, -1)) return false;

      // checks if there is an isolated island
      return v.size() == n;
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
      if (edges == null || edges.length == 0 || edges.length != n - 1 ||
              edges[0] == null || edges[0].length != 2) return false;

      List<HashSet<Integer>> graph = new ArrayList<>();
      for (int i = 0; i < n; i++) graph.add(new HashSet<Integer>());
      for (int[] edge : edges) {
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
      }

      Queue<Integer> q = new ArrayDeque<>();
      Set<Integer> v = new HashSet<>();
      q.offer(0);
      while (!q.isEmpty()) {
        int curr = q.poll();
        if (v.contains(curr)) return false;
        v.add(curr);

        for (int nbr : graph.get(curr)) {
          if (!v.contains(nbr)) q.offer(nbr);
        }
      }

      // checks if there is an isolated island
      return v.size() == n;
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
    private int findRoot(int[] root, int n) {
      while (root[n] != n) n = root[n];
      return n;
    }

    public boolean validTree(int n, int[][] edges) {
      if (edges == null || edges.length == 0 || edges.length != n - 1 ||
              edges[0] == null || edges[0].length != 2) return false;

      int[] root = new int[n];
      for (int i = 0; i < n; i++) root[i] = i;

      for (int[] edge : edges) {
        int x = findRoot(root, edge[0]);
        int y = findRoot(root, edge[1]);

        if (x == y) return false;
        // union
        root[x] = y;
      }

      return true;
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
