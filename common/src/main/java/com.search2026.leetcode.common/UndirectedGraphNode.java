package com.search2026.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/*
    Define a node class to be used in a undirected graph data structure
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
