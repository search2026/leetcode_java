package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.UndirectedGraphNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloneGraphTests {

    @Test
    public void testSolution() {
        CloneGraph.Solution sol = new CloneGraph().new Solution();
        UndirectedGraphNode root = new UndirectedGraphNode(5);
        UndirectedGraphNode child1 = new UndirectedGraphNode(1);
        UndirectedGraphNode child2 = new UndirectedGraphNode(7);
        UndirectedGraphNode child3 = new UndirectedGraphNode(9);
        UndirectedGraphNode child4 = new UndirectedGraphNode(18);
        UndirectedGraphNode child21 = new UndirectedGraphNode(8);
        UndirectedGraphNode child22 = new UndirectedGraphNode(11);

        root.neighbors.add(child1);
        root.neighbors.add(child2);
        root.neighbors.add(child3);
        root.neighbors.add(child4);
        child2.neighbors.add(child21);
        child2.neighbors.add(child22);

        UndirectedGraphNode cloned = sol.cloneGraph(root);
        assertEquals(5, cloned.label);
        assertEquals(4, cloned.neighbors.size());
        UndirectedGraphNode secondChild = cloned.neighbors.get(1);
        assertEquals(7, secondChild.label);
        assertEquals(2, secondChild.neighbors.size());
    }

    @Test
    public void testSolution2() {
        CloneGraph.Solution_2 sol = new CloneGraph().new Solution_2();
        UndirectedGraphNode root = new UndirectedGraphNode(5);
        UndirectedGraphNode child1 = new UndirectedGraphNode(1);
        UndirectedGraphNode child2 = new UndirectedGraphNode(7);
        UndirectedGraphNode child3 = new UndirectedGraphNode(9);
        UndirectedGraphNode child4 = new UndirectedGraphNode(18);
        UndirectedGraphNode child21 = new UndirectedGraphNode(8);
        UndirectedGraphNode child22 = new UndirectedGraphNode(11);

        root.neighbors.add(child1);
        root.neighbors.add(child2);
        root.neighbors.add(child3);
        root.neighbors.add(child4);
        child2.neighbors.add(child21);
        child2.neighbors.add(child22);

        UndirectedGraphNode cloned = sol.cloneGraph(root);
        assertEquals(5, cloned.label);
        assertEquals(4, cloned.neighbors.size());
    }

}
