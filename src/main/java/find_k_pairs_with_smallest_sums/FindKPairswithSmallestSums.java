package find_k_pairs_with_smallest_sums;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindKPairswithSmallestSums {
  /*
      Find K Pairs with Smallest Sums - No Priority Queue
      Leetcode #373
      https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
      Difficulty: Medium
   */
  public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<int[]> sPairs = new ArrayList<>();
      if (nums1 == null || nums1.length == 0 || nums2 == null
              || nums2.length == 0 || k == 0) return sPairs;

      int len1 = nums1.length, len2 = nums2.length;
      int[] nums2idx = new int[len1]; // map to last used element in nums2
      while (sPairs.size() < k) {
        int minSoFar = Integer.MAX_VALUE;
        int nums1pos = -1;
        // find smallest pair
        for (int i = 0; i < len1; i++) {
          if ((nums2idx[i] < len2) && (nums1[i] + nums2[nums2idx[i]] <= minSoFar)) {
            minSoFar = nums1[i] + nums2[nums2idx[i]];
            nums1pos = i;
          }
        }

        if (nums1pos == -1) {
          break;
        }

        sPairs.add(new int[]{nums1[nums1pos], nums2[nums2idx[nums1pos]]});
        nums2idx[nums1pos]++;
      }

      return sPairs;
    }
  }

  /*
      Find K Pairs with Smallest Sums - Priority Queue
      Leetcode #373
      https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
      Difficulty: Medium
   */
  public class Solution_2 {
    final int[][] neighbors = {{0, 1}, {1, 0}};

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<int[]> sPairs = new ArrayList<>();
      if (nums1 == null || nums1.length == 0 || nums2 == null
              || nums2.length == 0 || k == 0) return sPairs;

      int len1 = nums1.length, len2 = nums2.length;
      boolean[][] visited = new boolean[len1][len2];
      visited[0][0] = true;
      PriorityQueue<int[]> pq = new PriorityQueue<>((int[] pair1, int[] pair2) ->
              (nums1[pair1[0]] + nums2[pair1[1]]) - (nums1[pair2[0]] + nums2[pair2[1]]));
      pq.offer(new int[]{0, 0});

      while (sPairs.size() < k && !pq.isEmpty()) {
        int[] currPair = pq.poll();
        sPairs.add(new int[]{nums1[currPair[0]], nums2[currPair[1]]});

        for (int[] neighbor : neighbors) {
          int nums1pos = currPair[0] + neighbor[0];
          int nums2pos = currPair[1] + neighbor[1];
          if (nums1pos < 0 || nums1pos == len1 || nums2pos < 0 || nums2pos == len2 || visited[nums1pos][nums2pos]) {
            continue;
          }
          visited[nums1pos][nums2pos] = true;
          pq.offer(new int[]{nums1pos, nums2pos});
        }
      }

      return sPairs;
    }
  }

  /*
      Find K Pairs with Smallest Sums - dijkstra
      Leetcode #373
      https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
      Difficulty: Medium
   */
  public class Solution_3 {
    private void search(PriorityQueue<int[]> pq, boolean[][] visited, int[] nums1, int[] nums2, int n1, int n2) {
      if (n1 < nums1.length && n2 < nums2.length && !visited[n1][n2]) {
        pq.add(new int[]{n1, n2});
        visited[n1][n2] = true;
      }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<int[]> sPairs = new ArrayList<>();
      if (nums1 == null || nums1.length == 0 || nums2 == null
              || nums2.length == 0 || k == 0) return sPairs;

      PriorityQueue<int[]> pq = new PriorityQueue<>((int[] pair1, int[] pair2) ->
              (nums1[pair1[0]] + nums2[pair1[1]]) - (nums1[pair2[0]] + nums2[pair2[1]]));

      int len1 = nums1.length, len2 = nums2.length;
      boolean[][] visited = new boolean[len1][len2];
      search(pq, visited, nums1, nums2, 0, 0);

      while (pq.size() > 0 && sPairs.size() < k) {
        int[] next = pq.poll();
        sPairs.add(new int[]{nums1[next[0]], nums2[next[1]]});
        search(pq, visited, nums1, nums2, next[0] + 1, next[1]);
        search(pq, visited, nums1, nums2, next[0], next[1] + 1);
      }

      return sPairs;
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

