package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    /*
        Clone Graph - DFS
        Leetcode #133
        https://leetcode.com/problems/clone-graph/
        Difficulty: Medium
     */
    public class Solution {
        private UndirectedGraphNode clone(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
            if (node == null) return null;
            if (map.containsKey(node)) return map.get(node);

            UndirectedGraphNode nodeCloned = new UndirectedGraphNode(node.label);
            map.put(node, nodeCloned);
            for (UndirectedGraphNode nbr : node.neighbors) {
                nodeCloned.neighbors.add(clone(map, nbr));
            }

            return nodeCloned;
        }

        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
            return clone(map, node);
        }
    }

    /*
        Clone Graph - BFS
        Leetcode #133
        https://leetcode.com/problems/clone-graph/
        Difficulty: Medium
    */
    public class Solution_2 {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) return null;

            Queue<UndirectedGraphNode> q = new ArrayDeque<>();
            Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
            UndirectedGraphNode rootCloned = new UndirectedGraphNode(node.label);
            q.offer(node);
            map.put(node, rootCloned);

            while (!q.isEmpty()) {
                UndirectedGraphNode curr = q.poll();
                for (UndirectedGraphNode nbr : curr.neighbors) {
                    if (map.containsKey(nbr)) {
                        map.get(curr).neighbors.add(map.get(nbr));
                    } else {
                        q.offer(nbr);
                        UndirectedGraphNode nodeCloned = new UndirectedGraphNode(nbr.label);
                        map.get(curr).neighbors.add(nodeCloned);
                        map.put(nbr, nodeCloned);
                    }
                }
            }

            return rootCloned;
        }
    }

}
