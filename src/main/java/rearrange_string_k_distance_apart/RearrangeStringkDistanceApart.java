package rearrange_string_k_distance_apart;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class RearrangeStringkDistanceApart {
  /*
      Rearrange String k Distance Apart
      Leetcode #358
      https://leetcode.com/discuss/oj/rearrange-string-k-distance-apart
      http://www.cnblogs.com/grandyang/p/5586009.html
      Difficulty: Hard
   */
  public class Solution {
    public String rearrangeString(String str, int k) {
      if (str == null || str.length() == 0) return "";
      if (k == 0) return str;

      char[] arr = str.toCharArray();
      int n = arr.length;

      Map<Character, Integer> map = new HashMap<>();
      PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

      for (int i = 0; i < n; i++) {
        char c = arr[i];
        int count = map.getOrDefault(c, 0) + 1;
        map.put(c, count);
      }
      pq.addAll(map.entrySet());

      Deque<Map.Entry<Character, Integer>> queue = new ArrayDeque<>(k);

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (pq.size() == 0) {
          return "";
        }
        Map.Entry<Character, Integer> entry = pq.remove();
        sb.append(entry.getKey());
        int newVal = entry.getValue() - 1;
        entry.setValue(newVal);

        queue.offer(entry);
        if (queue.size() == k) {
          Map.Entry<Character, Integer> poll = queue.poll();
          if (poll.getValue() > 0) {
            pq.add(poll);
          }
        }
      }

      return sb.toString();
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new RearrangeStringkDistanceApart().new Solution();
//      assertTrue(sol.rearrangeString("aabbcc", 3).equals("abcabc"));
//      assertTrue(sol.rearrangeString("aaabc", 3).equals(""));
//      assertTrue(sol.rearrangeString("aaadbbcc", 2).equals("abacabcd") ||
//              sol.rearrangeString("aaadbbcc", 2).equals("abcabcda"));
    }
  }
}

