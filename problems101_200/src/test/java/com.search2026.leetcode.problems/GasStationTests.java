package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GasStationTests {

    @Test
    public void testSolution() {
        GasStation.Solution sol = new GasStation().new Solution();

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        assertEquals(3, sol.canCompleteCircuit(gas, cost));

        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        assertEquals(-1, sol.canCompleteCircuit(gas, cost));
    }

    @Test
    public void testSolution2() {
        GasStation.Solution_2 sol = new GasStation().new Solution_2();

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        assertEquals(3, sol.canCompleteCircuit(gas, cost));

        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        assertEquals(-1, sol.canCompleteCircuit(gas, cost));
    }

    @Test
    public void testSolution3() {
        GasStation.Solution_3 sol = new GasStation().new Solution_3();

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        assertEquals(3, sol.canCompleteCircuit(gas, cost));

        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        assertEquals(-1, sol.canCompleteCircuit(gas, cost));
    }

}
