package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTests {

    @Test
    public void testSolution() {
        Triangle.Solution sol = new Triangle().new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(){{add(2);}});
        triangle.add(new ArrayList<>(){{add(3);add(4);}});
        triangle.add(new ArrayList<>(){{add(6);add(5);add(7);}});
        triangle.add(new ArrayList<>(){{add(4);add(1);add(8);add(3);}});
        assertEquals(11, sol.minimumTotal(triangle));
    }

}
