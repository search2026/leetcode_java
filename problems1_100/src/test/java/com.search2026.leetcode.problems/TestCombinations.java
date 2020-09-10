package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCombinations {

    @Test
    public void test1() {
        Combinations.Solution sol = new Combinations().new Solution();
        List<List<Integer>> res = sol.combine(4, 2);
        assertEquals(6, res.size());
        assertEquals(2, res.get(0).size());
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).equals(o2.get(0)))
                    return o1.get(1) - o2.get(1);
                return o1.get(0) - o2.get(0);
            }
        });
        assertEquals(1, (int) res.get(0).get(0));
        assertEquals(2, (int) res.get(0).get(1));
        assertEquals(3, (int) res.get(res.size() - 1).get(0));
        assertEquals(4, (int) res.get(res.size() - 1).get(1));
    }

    @Test
    public void test2() {
        Combinations.Solution_2 sol = new Combinations().new Solution_2();
        List<List<Integer>> res = sol.combine(4, 2);
        assertEquals(6, res.size());
        assertEquals(2, res.get(0).size());
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).equals(o2.get(0)))
                    return o1.get(1) - o2.get(1);
                return o1.get(0) - o2.get(0);
            }
        });
        assertEquals(1, (int) res.get(0).get(0));
        assertEquals(2, (int) res.get(0).get(1));
        assertEquals(3, (int) res.get(res.size() - 1).get(0));
        assertEquals(4, (int) res.get(res.size() - 1).get(1));
    }

    @Test
    public void test3() {
        Combinations.Solution_3 sol = new Combinations().new Solution_3();
        List<List<Integer>> res = sol.combine(4, 2);
        assertEquals(6, res.size());
        assertEquals(2, res.get(0).size());
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).equals(o2.get(0)))
                    return o1.get(1) - o2.get(1);
                return o1.get(0) - o2.get(0);
            }
        });
        assertEquals(1, (int) res.get(0).get(0));
        assertEquals(2, (int) res.get(0).get(1));
        assertEquals(3, (int) res.get(res.size() - 1).get(0));
        assertEquals(4, (int) res.get(res.size() - 1).get(1));
    }

    @Test
    public void test4() {
        Combinations.Solution_4 sol = new Combinations().new Solution_4();
        List<List<Integer>> res = sol.combine(4, 2);
        assertEquals(6, res.size());
        assertEquals(2, res.get(0).size());
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).equals(o2.get(0)))
                    return o1.get(1) - o2.get(1);
                return o1.get(0) - o2.get(0);
            }
        });
        assertEquals(1, (int) res.get(0).get(0));
        assertEquals(2, (int) res.get(0).get(1));
        assertEquals(3, (int) res.get(res.size() - 1).get(0));
        assertEquals(4, (int) res.get(res.size() - 1).get(1));
    }

}
