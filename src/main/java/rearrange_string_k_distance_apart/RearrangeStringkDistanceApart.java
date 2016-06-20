package rearrange_string_k_distance_apart;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

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

        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      pq.addAll(map.entrySet());

      Deque<Map.Entry<Character, Integer>> q = new ArrayDeque<>(k);
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (pq.size() == 0) return "";

        Map.Entry<Character, Integer> entry = pq.poll();
        sb.append(entry.getKey());
        entry.setValue(entry.getValue() - 1);
        q.offer(entry);
        if (q.size() == k) {
          Map.Entry<Character, Integer> curr = q.poll();
          if (curr.getValue() > 0) pq.add(curr);
        }
      }

      return sb.toString();
    }
  }

  /*
      Rearrange String k Distance Apart
      Leetcode #358
      https://leetcode.com/discuss/oj/rearrange-string-k-distance-apart
      http://www.cnblogs.com/grandyang/p/5586009.html
      Difficulty: Hard
   */
  public class Solution_2 {
    private int findValidMax(int[] count, int[] valid, int index) {
      int max = Integer.MIN_VALUE;
      int candidatePos = -1;
      for (int i = 0; i < count.length; i++) {
        if (count[i] > 0 && count[i] > max && index >= valid[i]) {
          max = count[i];
          candidatePos = i;
        }
      }
      return candidatePos;
    }

    public String rearrangeString(String str, int k) {
      int length = str.length();
      int[] count = new int[26];
      int[] valid = new int[26];
      for (int i = 0; i < length; i++) {
        count[str.charAt(i) - 'a']++;
      }
      StringBuilder sb = new StringBuilder();
      for (int index = 0; index < length; index++) {
        int cand = findValidMax(count, valid, index);
        if (cand == -1) return "";
        count[cand]--;
        valid[cand] = index + k;
        sb.append((char) ('a' + cand));
      }
      return sb.toString();
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new RearrangeStringkDistanceApart().new Solution();
      String rslt = sol.rearrangeString("aabbcc", 3);
      assertEquals("acbacb", rslt);
      rslt = sol.rearrangeString("aaabc", 3);
      assertEquals("", rslt);
      rslt = sol.rearrangeString("aaadbbcc", 2);
      assertEquals("abcabcad", rslt);
    }

    @Test
    public void test2() {
      Solution_2 sol = new RearrangeStringkDistanceApart().new Solution_2();
      String rslt = sol.rearrangeString("aabbcc", 3);
      assertEquals("abcabc", rslt);
      rslt = sol.rearrangeString("aaabc", 3);
      assertEquals("", rslt);
      rslt = sol.rearrangeString("aaadbbcc", 2);
      assertEquals("abacabcd", rslt);
    }
  }
}

