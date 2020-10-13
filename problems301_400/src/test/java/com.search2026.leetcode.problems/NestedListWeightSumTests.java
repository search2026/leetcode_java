package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.NestedInteger;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NestedListWeightSumTests {

    @Test
    public void testSolution() {
        NestedListWeightSum.Solution sol = new NestedListWeightSum().new Solution();

        NestedInteger ni1 = new NestedInteger(1);
        NestedInteger ni2 = new NestedInteger(2);
        NestedInteger ni11 = new NestedInteger();
        ni11.add(ni1);
        ni11.add(ni1);
        List<NestedInteger> ni = new LinkedList<>();
        ni.add(ni11);
        ni.add(ni2);
        ni.add(ni11);
        assertEquals(10, sol.depthSum(ni));

        NestedInteger ni4 = new NestedInteger(4);
        NestedInteger ni6 = new NestedInteger(6);
        NestedInteger ni6list = new NestedInteger();
        ni6list.add(ni6);
        NestedInteger ni46list = new NestedInteger();
        ni46list.add(ni4);
        ni46list.add(ni6list);
        ni.clear();
        ni.add(ni1);
        ni.add(ni46list);
        assertEquals(27, sol.depthSum(ni));
    }

    @Test
    public void testSolution2() {
        NestedListWeightSum.Solution_2 sol = new NestedListWeightSum().new Solution_2();

        NestedInteger ni1 = new NestedInteger(1);
        NestedInteger ni2 = new NestedInteger(2);
        NestedInteger ni11 = new NestedInteger();
        ni11.add(ni1);
        ni11.add(ni1);
        List<NestedInteger> ni = new LinkedList<>();
        ni.add(ni11);
        ni.add(ni2);
        ni.add(ni11);
//        assertEquals(10, sol.depthSum(ni));

        NestedInteger ni4 = new NestedInteger(4);
        NestedInteger ni6 = new NestedInteger(6);
        NestedInteger ni6list = new NestedInteger();
        ni6list.add(ni6);
        NestedInteger ni46list = new NestedInteger();
        ni46list.add(ni4);
        ni46list.add(ni6list);
        ni.clear();
        ni.add(ni1);
        ni.add(ni46list);
//        assertEquals(27, sol.depthSum(ni));
    }

    @Test
    public void testSolution3() {
        NestedListWeightSum.Solution_3 sol = new NestedListWeightSum().new Solution_3();

        NestedInteger ni1 = new NestedInteger(1);
        NestedInteger ni2 = new NestedInteger(2);
        NestedInteger ni11 = new NestedInteger();
        ni11.add(ni1);
        ni11.add(ni1);
        List<NestedInteger> ni = new LinkedList<>();
        ni.add(ni11);
        ni.add(ni2);
        ni.add(ni11);
        assertEquals(8, sol.depthSumInverse(ni));

        NestedInteger ni4 = new NestedInteger(4);
        NestedInteger ni6 = new NestedInteger(6);
        NestedInteger ni6list = new NestedInteger();
        ni6list.add(ni6);
        NestedInteger ni46list = new NestedInteger();
        ni46list.add(ni4);
        ni46list.add(ni6list);
        ni.clear();
        ni.add(ni1);
        ni.add(ni46list);
        assertEquals(17, sol.depthSumInverse(ni));
    }

    @Test
    public void testSolution4() {
        NestedListWeightSum.Solution_4 sol = new NestedListWeightSum().new Solution_4();

        NestedInteger ni1 = new NestedInteger(1);
        NestedInteger ni2 = new NestedInteger(2);
        NestedInteger ni11 = new NestedInteger();
        ni11.add(ni1);
        ni11.add(ni1);
        List<NestedInteger> ni = new LinkedList<>();
        ni.add(ni11);
        ni.add(ni2);
        ni.add(ni11);
        assertEquals(8, sol.depthSumInverse(ni));

        NestedInteger ni4 = new NestedInteger(4);
        NestedInteger ni6 = new NestedInteger(6);
        NestedInteger ni6list = new NestedInteger();
        ni6list.add(ni6);
        NestedInteger ni46list = new NestedInteger();
        ni46list.add(ni4);
        ni46list.add(ni6list);
        ni.clear();
        ni.add(ni1);
        ni.add(ni46list);
        assertEquals(17, sol.depthSumInverse(ni));
    }

    @Test
    public void testSolution5() {
        NestedListWeightSum.Solution_5 sol = new NestedListWeightSum().new Solution_5();

        NestedInteger ni1 = new NestedInteger(1);
        NestedInteger ni2 = new NestedInteger(2);
        NestedInteger ni11 = new NestedInteger();
        ni11.add(ni1);
        ni11.add(ni1);
        List<NestedInteger> ni = new LinkedList<>();
        ni.add(ni11);
        ni.add(ni2);
        ni.add(ni11);
        assertEquals(8, sol.depthSumInverse(ni));

        NestedInteger ni4 = new NestedInteger(4);
        NestedInteger ni6 = new NestedInteger(6);
        NestedInteger ni6list = new NestedInteger();
        ni6list.add(ni6);
        NestedInteger ni46list = new NestedInteger();
        ni46list.add(ni4);
        ni46list.add(ni6list);
        ni.clear();
        ni.add(ni1);
        ni.add(ni46list);
        assertEquals(17, sol.depthSumInverse(ni));
    }

}
