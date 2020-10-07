package com.search2026.leetcode.problems;

import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {

    /*
        Zigzag Iterator
        Leetcode #281
        https://leetcode.com/discuss/questions/oj/zigzag-iterator
        http://buttercola.blogspot.com/2015/09/leetocode-zigzag-iterator.html
        Difficulty: Medium
     */
    private List<Integer> v1;
    private List<Integer> v2;
    private int i;
    private int j;
    private int listId;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.i = 0;
        this.j = 0;
        this.listId = 0;
    }

    public int next() {
        int res = 0;
        if (i >= v1.size()) {
            res = v2.get(j);
            j++;
        } else if (j >= v2.size()) {
            res = v1.get(i);
            i++;
        } else {
            if (listId == 0) {
                res = v1.get(i);
                i++;
                listId = 1;
            } else {
                res = v2.get(j);
                j++;
                listId = 0;
            }
        }

        return res;
    }

    public boolean hasNext() {
        return i < v1.size() || j < v2.size();
    }

}
