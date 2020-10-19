package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerRateLimiterTests {

    @Test
    public void test1() {
        LoggerRateLimiter.Logger logger = new LoggerRateLimiter().new Logger();
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
        LoggerRateLimiter.Solution logger = new LoggerRateLimiter().new Solution();
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
