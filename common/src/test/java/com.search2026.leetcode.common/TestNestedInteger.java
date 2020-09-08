package com.search2026.leetcode.common;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestNestedInteger {

    @Test
    public void testNestedIntegerInitialization() {
        //[[1,1],2,[1,1]]
        NestedInteger oneInt = new NestedInteger(1);
        List<NestedInteger> list = new ArrayList<>();
        list.add(oneInt);
        list.add(oneInt);
        NestedInteger first = new NestedInteger(list);
        NestedInteger second = new NestedInteger(2);
        NestedInteger third = new NestedInteger(list);

        NestedInteger root = new NestedInteger();
        root.add(first);
        root.add(second);
        root.add(third);

        List<NestedInteger> res = root.getList();
        assertFalse(res.get(0).isInteger());
        assertTrue(res.get(1).isInteger());
        assertFalse(res.get(2).isInteger());

    }
}
