package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPermutations {

    @Test
    public void test1() {
        Permutations.Solution sol = new Permutations().new Solution();
        int[] test = {1, 2, 3};
        List<List<Integer>> res = sol.permute(test);
        assertEquals(6, res.size());
        assertEquals(test.length, res.get(0).size());
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
        assertEquals(3, (int) res.get(0).get(2));
        assertEquals(3, (int) res.get(res.size() - 1).get(0));
        assertEquals(2, (int) res.get(res.size() - 1).get(1));
        assertEquals(1, (int) res.get(res.size() - 1).get(2));
    }

    @Test
    public void test2() {
        Permutations.Solution_2 sol = new Permutations().new Solution_2();
        int[] test = {1, 2, 3};
        List<List<Integer>> res = sol.permute(test);
        assertEquals(6, res.size());
        assertEquals(test.length, res.get(0).size());
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
        assertEquals(3, (int) res.get(0).get(2));
        assertEquals(3, (int) res.get(res.size() - 1).get(0));
        assertEquals(2, (int) res.get(res.size() - 1).get(1));
        assertEquals(1, (int) res.get(res.size() - 1).get(2));
    }

    @Test
    public void test3() {
        Permutations.Solution_3 sol = new Permutations().new Solution_3();
        int[] test = {1, 2, 1};
        List<List<Integer>> res = sol.permuteUnique(test);
        assertEquals(3, res.size());
        assertEquals(test.length, res.get(0).size());
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).equals(o2.get(0)))
                    return o1.get(1) - o2.get(1);
                return o1.get(0) - o2.get(0);
            }
        });
        assertEquals(1, (int) res.get(0).get(0));
        assertEquals(1, (int) res.get(0).get(1));
        assertEquals(2, (int) res.get(0).get(2));
        assertEquals(2, (int) res.get(res.size() - 1).get(0));
        assertEquals(1, (int) res.get(res.size() - 1).get(1));
        assertEquals(1, (int) res.get(res.size() - 1).get(2));
    }

    @Test
    public void test4() {
        Permutations.Solution_4 sol = new Permutations().new Solution_4();
        int[] test = {1, 2, 1};
        List<List<Integer>> res = sol.permuteUnique(test);
        assertEquals(3, res.size());
        assertEquals(test.length, res.get(0).size());
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).equals(o2.get(0)))
                    return o1.get(1) - o2.get(1);
                return o1.get(0) - o2.get(0);
            }
        });
        assertEquals(1, (int) res.get(0).get(0));
        assertEquals(1, (int) res.get(0).get(1));
        assertEquals(2, (int) res.get(0).get(2));
        assertEquals(2, (int) res.get(res.size() - 1).get(0));
        assertEquals(1, (int) res.get(res.size() - 1).get(1));
        assertEquals(1, (int) res.get(res.size() - 1).get(2));
    }

}
