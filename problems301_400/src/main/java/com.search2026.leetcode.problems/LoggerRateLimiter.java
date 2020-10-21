package com.search2026.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    /*
        Logger Rate Limiter
        Leetcode #359
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/LoggerRateLimiter.md
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
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/LoggerRateLimiter.md
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

}
