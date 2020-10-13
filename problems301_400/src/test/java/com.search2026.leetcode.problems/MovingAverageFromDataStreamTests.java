package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovingAverageFromDataStreamTests {

    @Test
    public void testSolution() {
        MovingAverageFromDataStream.MovingAverage sol = new MovingAverageFromDataStream().new MovingAverage(3);
        assertEquals(1.0, sol.next(1), 0.001);
        assertEquals(5.5, sol.next(10), 0.001);
        assertEquals(4.666, sol.next(3), 0.001);
        assertEquals(6.0, sol.next(5), 0.001);
    }

    @Test
    public void testSolution2() {
        MovingAverageFromDataStream.MovingAverage_2 sol = new MovingAverageFromDataStream().new MovingAverage_2(3);
        assertEquals(1.0, sol.next(1), 0.001);
        assertEquals(5.5, sol.next(10), 0.001);
        assertEquals(4.666, sol.next(3), 0.001);
        assertEquals(6.0, sol.next(5), 0.001);
    }

}
