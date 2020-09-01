package com.search2026.leetcode.common;

public class SegmentTreeNode {
    public long start, end, val;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(long start, long end) {
        this.start = start;
        this.end = end;
        this.val = 0;
        left = null;
        right = null;
    }

    public SegmentTreeNode(long start, long end, long val) {
        this.start = start;
        this.end = end;
        this.val = val;
        left = null;
        right = null;
    }
}
