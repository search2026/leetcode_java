package design_hit_counter;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignHitCounter {
  /*
      Design Hit Counter
      Leetcode #362
      https://leetcode.com/discuss/questions/oj/design-hit-counter?sort=votes
      http://www.cnblogs.com/grandyang/p/5605552.html
      Difficulty: Medium
   */
  public class HitCounter {
    private int[] times;
    private int[] hits;
    private final int CHECK_RANGE_SECONDS = 300;

    /** Initialize your data structure here. */
    public HitCounter() {
      times = new int[CHECK_RANGE_SECONDS];
      hits = new int[CHECK_RANGE_SECONDS];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
      int index = timestamp % CHECK_RANGE_SECONDS;
      if (times[index] != timestamp) {
        times[index] = timestamp;
        hits[index] = 1;
      } else {
        hits[index]++;
      }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
      int count = 0;
      for (int i = 0; i < CHECK_RANGE_SECONDS; i++) {
        if (timestamp - times[i] < CHECK_RANGE_SECONDS) {
          count += hits[i];
        }
      }
      return count;
    }
  }

  /*
      Design Hit Counter - Queue
      Leetcode #362
      https://leetcode.com/discuss/questions/oj/design-hit-counter?sort=votes
      http://www.cnblogs.com/grandyang/p/5605552.html
      Difficulty: Medium
   */
  public class HitCounter_2 {
    Queue<Integer> q;
    private final int CHECK_RANGE_SECONDS = 300;

    /** Initialize your data structure here. */
    public HitCounter_2() {
      q = new ArrayDeque<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
      q.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
      while(!q.isEmpty() && timestamp - q.peek() >= CHECK_RANGE_SECONDS) {
        q.poll();
      }
      return q.size();
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      HitCounter counter = new DesignHitCounter().new HitCounter();
      // hit at timestamp 1.
      counter.hit(1);
      // hit at timestamp 2.
      counter.hit(2);
      // hit at timestamp 3.
      counter.hit(3);
      // get hits at timestamp 4, should return 3.
      assertEquals(3, counter.getHits(4));
      // hit at timestamp 300.
      counter.hit(300);
      // get hits at timestamp 300, should return 4.
      assertEquals(4, counter.getHits(300));
      // get hits at timestamp 301, should return 3.
      assertEquals(3, counter.getHits(301));
    }

    @Test
    public void test2() {
      HitCounter_2 counter = new DesignHitCounter().new HitCounter_2();
      // hit at timestamp 1.
      counter.hit(1);
      // hit at timestamp 2.
      counter.hit(2);
      // hit at timestamp 3.
      counter.hit(3);
      // get hits at timestamp 4, should return 3.
      assertEquals(3, counter.getHits(4));
      // hit at timestamp 300.
      counter.hit(300);
      // get hits at timestamp 300, should return 4.
      assertEquals(4, counter.getHits(300));
      // get hits at timestamp 301, should return 3.
      assertEquals(3, counter.getHits(301));
    }
  }
}

