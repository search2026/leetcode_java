package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReconstructItineraryTests {

    @Test
    public void testSolution() {
        ReconstructItinerary.Solution sol = new ReconstructItinerary().new Solution();
        String[][] tickets = {
                {"MUC", "LHR"},
                {"JFK", "MUC"},
                {"SFO", "SJC"},
                {"LHR", "SFO"}
        };
        List<String> res = sol.findItinerary(tickets);
        String[] tmpArray = new String[res.size()];
        tmpArray = res.toArray(tmpArray);
        assertArrayEquals(new String[]{"JFK", "MUC", "LHR", "SFO", "SJC"}, tmpArray);

        tickets = new String[][]{
                new String[]{"JFK", "SFO"},
                new String[]{"JFK", "ATL"},
                new String[]{"SFO", "ATL"},
                new String[]{"ATL", "JFK"},
                new String[]{"ATL", "SFO"}
        };
        res = sol.findItinerary(tickets);
        tmpArray = new String[res.size()];
        tmpArray = res.toArray(tmpArray);
        assertArrayEquals(new String[]{"JFK", "ATL", "JFK", "SFO", "ATL", "SFO"}, tmpArray);
    }

}
