package find_k_pairs_with_smallest_sums;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class FindKPairswithSmallestSums {
  /*
      Find K Pairs with Smallest Sums - Priority Queue
      Leetcode #373
      https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
      Difficulty: Medium
   */
  public class Solution {
    final int[][] neighbors = {{0, 1}, {1, 0}};

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<int[]> list = new ArrayList<>();
      if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
        return list;
      }
      int m = nums1.length, n = nums2.length;
      boolean[][] visited = new boolean[m][n];
      Queue<Pair> minHeap = new PriorityQueue<>();
      minHeap.offer(new Pair(0, 0, nums1[0] + nums2[0]));
      visited[0][0] = true;
      while (k > 0 && !minHeap.isEmpty()) {
        Pair min = minHeap.poll();
        list.add(new int[] {nums1[min.row], nums2[min.col]});
        k--;
        for (int[] neighbor : neighbors) {
          int row1 = min.row + neighbor[0];
          int col1 = min.col + neighbor[1];
          if (row1 < 0 || row1 == m || col1 < 0 || col1 == n || visited[row1][col1]) {
            continue;
          }
          visited[row1][col1] = true;
          minHeap.offer(new Pair(row1, col1, nums1[row1] + nums2[col1]));
        }
      }
      return list;
    }

    private class Pair implements Comparable<Pair> {
      int row;
      int col;
      int value;

      Pair(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
      }

      public int compareTo(Pair other) {
        return value - other.value;
      }
    }
  }

  /*
      Find K Pairs with Smallest Sums - dijkstra
      Leetcode #373
      https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
      Difficulty: Medium
   */
  public class Solution_2 {
    private void add(PriorityQueue<int[]> pq, boolean[][] visited, int[] nums1, int[] nums2, int n1, int n2){
      if(n1 < nums1.length && n2 < nums2.length && !visited[n1][n2]){
        pq.add(new int[]{n1, n2});
        visited[n1][n2] = true;
      }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<int[]> result = new ArrayList<int[]>();
      PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
        public int compare(int[] pair1, int[] pair2){
          return (nums1[pair1[0]] + nums2[pair1[1]]) - (nums1[pair2[0]] + nums2[pair2[1]]);
        }
      });

      int length1 = nums1.length;
      int length2 = nums2.length;
      boolean[][] visited = new boolean[length1][length2];

      add(pq, visited, nums1, nums2, 0, 0);
      while(pq.size() > 0 && result.size() < k){
        int[] next = pq.poll();
        result.add(new int[]{nums1[next[0]], nums2[next[1]]});
        add(pq, visited, nums1, nums2, next[0] + 1, next[1]);
        add(pq, visited, nums1, nums2, next[0], next[1] + 1);
      }

      return result;
    }
  }

  /*
      Find K Pairs with Smallest Sums - Priority Queue
      Leetcode #373
      https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
      Difficulty: Medium
   */
  public class Solution_3 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<int[]> ret = new ArrayList<int[]>();
      if (nums1.length == 0 || nums2.length == 0 || k == 0) {
        return ret;
      }

      int[] index = new int[nums1.length];
      while (k-- > 0) {
        int min_val = Integer.MAX_VALUE;
        int in = -1;
        for (int i = 0; i < nums1.length; i++) {
          if (index[i] >= nums2.length) {
            continue;
          }
          if (nums1[i] + nums2[index[i]] < min_val) {
            min_val = nums1[i] + nums2[index[i]];
            in = i;
          }
        }
        if (in == -1) {
          break;
        }
        int[] temp = {nums1[in], nums2[index[in]]};
        ret.add(temp);
        index[in]++;
      }
      return ret;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new FindKPairswithSmallestSums().new Solution();
      int[] test1 = {1, 7, 11};
      int[] test2 = {2, 4, 6};
      List<int[]> result = sol.kSmallestPairs(test1, test2, 3);
      assertEquals(3, result.size());
      assertEquals(2, result.get(0).length);
      assertEquals(1, result.get(0)[0]);
      assertEquals(2, result.get(0)[1]);
      assertEquals(2, result.get(1).length);
      assertEquals(1, result.get(1)[0]);
      assertEquals(4, result.get(1)[1]);
      assertEquals(2, result.get(2).length);
      assertEquals(1, result.get(2)[0]);
      assertEquals(6, result.get(2)[1]);

      test1 = new int[]{1, 1, 2};
      test2 = new int[]{1, 2, 3};
      result = sol.kSmallestPairs(test1, test2, 2);
      assertEquals(2, result.size());
      assertEquals(2, result.get(0).length);
      assertEquals(1, result.get(0)[0]);
      assertEquals(1, result.get(0)[1]);
      assertEquals(2, result.get(1).length);
      assertEquals(1, result.get(1)[0]);
      assertEquals(1, result.get(1)[1]);

      test1 = new int[]{1, 2};
      test2 = new int[]{3};
      result = sol.kSmallestPairs(test1, test2, 3);
      assertEquals(2, result.size());
      assertEquals(2, result.get(0).length);
      assertEquals(1, result.get(0)[0]);
      assertEquals(3, result.get(0)[1]);
      assertEquals(2, result.get(1).length);
      assertEquals(2, result.get(1)[0]);
      assertEquals(3, result.get(1)[1]);
    }

    @Test
    public void test2() {
      Solution_2 sol = new FindKPairswithSmallestSums().new Solution_2();
      int[] test1 = {1, 7, 11};
      int[] test2 = {2, 4, 6};
      List<int[]> result = sol.kSmallestPairs(test1, test2, 3);
      assertEquals(3, result.size());
      assertEquals(2, result.get(0).length);
      assertEquals(1, result.get(0)[0]);
      assertEquals(2, result.get(0)[1]);
      assertEquals(2, result.get(1).length);
      assertEquals(1, result.get(1)[0]);
      assertEquals(4, result.get(1)[1]);
      assertEquals(2, result.get(2).length);
      assertEquals(1, result.get(2)[0]);
      assertEquals(6, result.get(2)[1]);

      test1 = new int[]{1, 1, 2};
      test2 = new int[]{1, 2, 3};
      result = sol.kSmallestPairs(test1, test2, 2);
      assertEquals(2, result.size());
      assertEquals(2, result.get(0).length);
      assertEquals(1, result.get(0)[0]);
      assertEquals(1, result.get(0)[1]);
      assertEquals(2, result.get(1).length);
      assertEquals(1, result.get(1)[0]);
      assertEquals(1, result.get(1)[1]);

      test1 = new int[]{1, 2};
      test2 = new int[]{3};
      result = sol.kSmallestPairs(test1, test2, 3);
      assertEquals(2, result.size());
      assertEquals(2, result.get(0).length);
      assertEquals(1, result.get(0)[0]);
      assertEquals(3, result.get(0)[1]);
      assertEquals(2, result.get(1).length);
      assertEquals(2, result.get(1)[0]);
      assertEquals(3, result.get(1)[1]);
    }

    @Test
    public void test3() {
      Solution_3 sol = new FindKPairswithSmallestSums().new Solution_3();
      int[] test1 = {1, 7, 11};
      int[] test2 = {2, 4, 6};
      List<int[]> result = sol.kSmallestPairs(test1, test2, 3);
      assertEquals(3, result.size());
      assertEquals(2, result.get(0).length);
      assertEquals(1, result.get(0)[0]);
      assertEquals(2, result.get(0)[1]);
      assertEquals(2, result.get(1).length);
      assertEquals(1, result.get(1)[0]);
      assertEquals(4, result.get(1)[1]);
      assertEquals(2, result.get(2).length);
      assertEquals(1, result.get(2)[0]);
      assertEquals(6, result.get(2)[1]);

      test1 = new int[]{1, 1, 2};
      test2 = new int[]{1, 2, 3};
      result = sol.kSmallestPairs(test1, test2, 2);
      assertEquals(2, result.size());
      assertEquals(2, result.get(0).length);
      assertEquals(1, result.get(0)[0]);
      assertEquals(1, result.get(0)[1]);
      assertEquals(2, result.get(1).length);
      assertEquals(1, result.get(1)[0]);
      assertEquals(1, result.get(1)[1]);

      test1 = new int[]{1, 2};
      test2 = new int[]{3};
      result = sol.kSmallestPairs(test1, test2, 3);
      assertEquals(2, result.size());
      assertEquals(2, result.get(0).length);
      assertEquals(1, result.get(0)[0]);
      assertEquals(3, result.get(0)[1]);
      assertEquals(2, result.get(1).length);
      assertEquals(2, result.get(1)[0]);
      assertEquals(3, result.get(1)[1]);
    }
  }
}

