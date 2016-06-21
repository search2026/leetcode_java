package design_hit_counter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesignHitCounter {
  /*
      Design Hit Counter
      Leetcode #362
      https://leetcode.com/discuss/oj/design-hit-counter

   */
  public class Solution {
    public class HitCounter {
      private int[] times;
      private int[] hits;

      /**
       * Initialize your data structure here.
       */
      public HitCounter() {
        times = new int[300];
        hits = new int[300];
      }

      /**
       * Record a hit.
       *
       * @param timestamp - The current timestamp (in seconds granularity).
       */
      public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
          times[index] = timestamp;
          hits[index] = 1;
        } else {
          hits[index]++;
        }
      }

      /**
       * Return the number of hits in the past 5 minutes.
       *
       * @param timestamp - The current timestamp (in seconds granularity).
       */
      public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
          if (timestamp - times[i] < 300) {
            total += hits[i];
          }
        }
        return total;
      }
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new DesignHitCounter().new Solution();
      assertEquals(1, 1);
    }
  }
}

