package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.NestedInteger;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlattenNestedListIteratorTests {

    @Test
    public void testSolution() {
        NestedInteger ni1 = new NestedInteger(1);
        NestedInteger ni2 = new NestedInteger(2);
        NestedInteger ni11 = new NestedInteger();
        ni11.add(ni1);
        ni11.add(ni1);
        List<NestedInteger> ni = new LinkedList<>();
        ni.add(ni11);
        ni.add(ni2);
        ni.add(ni11);
        FlattenNestedListIterator.NestedIterator niIter = new FlattenNestedListIterator().new NestedIterator(ni);
        List<Integer> resList = new LinkedList<>();
        while (niIter.hasNext()) {
            resList.add(niIter.next());
        }
        Integer[] resArray = new Integer[resList.size()];
        assertArrayEquals(new Integer[]{1, 1, 2, 1, 1}, resList.toArray(resArray));

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
        resList.clear();
        while (niIter.hasNext()) {
            resList.add(niIter.next());
        }
        resArray = new Integer[resList.size()];
//        assertArrayEquals(new Integer[]{1, 4, 6}, resList.toArray(resArray));
    }

    @Test
    public void testSolution2() {
        NestedInteger ni1 = new NestedInteger(1);
        NestedInteger ni2 = new NestedInteger(2);
        NestedInteger ni11 = new NestedInteger();
        ni11.add(ni1);
        ni11.add(ni1);
        List<NestedInteger> ni = new LinkedList<>();
        ni.add(ni11);
        ni.add(ni2);
        ni.add(ni11);
        FlattenNestedListIterator.NestedIterator_2 niIter = new FlattenNestedListIterator().new NestedIterator_2(ni);
        List<Integer> resList = new LinkedList<>();
        while (niIter.hasNext()) {
            resList.add(niIter.next());
        }
        Integer[] resArray = new Integer[resList.size()];
        assertArrayEquals(new Integer[]{1, 1, 2, 1, 1}, resList.toArray(resArray));

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
        resList.clear();
        while (niIter.hasNext()) {
            resList.add(niIter.next());
        }
        resArray = new Integer[resList.size()];
//        assertArrayEquals(new Integer[]{1, 4, 6}, resList.toArray(resArray));
    }

}
