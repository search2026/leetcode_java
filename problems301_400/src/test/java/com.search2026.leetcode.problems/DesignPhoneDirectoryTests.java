package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DesignPhoneDirectoryTests {

    @Test
    public void testSolution() {
        // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
        DesignPhoneDirectory.PhoneDirectory directory = new DesignPhoneDirectory().new PhoneDirectory(3);

        // It can return any available phone number. Here we assume it returns 0.
        assertEquals(0, directory.get());

        // Assume it returns 1.
        assertEquals(1, directory.get());

        // The number 2 is available, so return true.
        assertTrue(directory.check(2));

        // It returns 2, the only number that is left.
        assertEquals(2, directory.get());

        // The number 2 is no longer available, so return false.
        assertFalse(directory.check(2));

        // Release number 2 back to the pool.
        directory.release(2);

        // Number 2 is available again, return true.
        assertTrue(directory.check(2));
    }

}
