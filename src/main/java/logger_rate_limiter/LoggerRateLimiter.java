package logger_rate_limiter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class LoggerRateLimiter {
  /*
      Logger Rate Limiter
      Leetcode #359
      https://leetcode.com/discuss/questions/oj/logger-rate-limiter?sort=votes
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

  /*
      Logger Rate Limiter
      Leetcode #359
      https://leetcode.com/discuss/questions/oj/logger-rate-limiter?sort=votes
      http://www.cnblogs.com/grandyang/p/5592635.html
      Difficult: Easy
   */
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
      Logger logger = new LoggerRateLimiter().new Logger();
      // logging string "foo" at timestamp 1
      assertTrue(logger.shouldPrintMessage(1, "foo"));
      // logging string "bar" at timestamp 2
      assertTrue(logger.shouldPrintMessage(2,"bar"));
      // logging string "foo" at timestamp 3
      assertFalse(logger.shouldPrintMessage(3,"foo"));
      // logging string "bar" at timestamp 8
      assertFalse(logger.shouldPrintMessage(8,"bar"));
      // logging string "foo" at timestamp 10
      assertFalse(logger.shouldPrintMessage(10,"foo"));
      // logging string "foo" at timestamp 11
      assertTrue(logger.shouldPrintMessage(11,"foo"));
      // logging string "bar" at timestamp 11
      assertFalse(logger.shouldPrintMessage(11,"bar"));
      // logging string "bar" at timestamp 12
      assertTrue(logger.shouldPrintMessage(12,"bar"));
    }

    @Test
    public void test2() {
      Solution logger = new LoggerRateLimiter().new Solution();
      // logging string "foo" at timestamp 1
      assertTrue(logger.shouldPrintMessage(1, "foo"));
      // logging string "bar" at timestamp 2
      assertTrue(logger.shouldPrintMessage(2,"bar"));
      // logging string "foo" at timestamp 3
      assertFalse(logger.shouldPrintMessage(3,"foo"));
      // logging string "bar" at timestamp 8
      assertFalse(logger.shouldPrintMessage(8,"bar"));
      // logging string "foo" at timestamp 10
      assertFalse(logger.shouldPrintMessage(10,"foo"));
      // logging string "foo" at timestamp 11
      assertTrue(logger.shouldPrintMessage(11,"foo"));
      // logging string "bar" at timestamp 11
      assertFalse(logger.shouldPrintMessage(11,"bar"));
      // logging string "bar" at timestamp 12
      assertTrue(logger.shouldPrintMessage(12,"bar"));
    }
  }
}

