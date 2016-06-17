package logger_rate_limiter;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LoggerRateLimiter {
  /*
      Logger Rate Limiter
      Leetcode #359
      https://leetcode.com/discuss/questions/oj/logger-rate-limiter
      http://www.cnblogs.com/grandyang/p/5592635.html
      Difficult: Easy
   */
  public class Solution {
    /**
     * Initialize your data structure here.
     */
    private Map<String, Integer> map = new HashMap<>();

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
      if (timestamp < map.getOrDefault(message, 0))
        return false;
      map.put(message, timestamp + 10);
      return true;
    }
  }

  public class Logger {
    /**
     * Initialize your data structure here.
     */
    Map<String, Integer> map;

    public Logger() {
      map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
      Integer prev = map.get(message);
      if (prev == null || timestamp - prev >= 10) {
        map.put(message, timestamp);
        return true;
      } else {
        return false;
      }
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new LoggerRateLimiter().new Solution();
      assertEquals(1, 1);
    }
  }
}

