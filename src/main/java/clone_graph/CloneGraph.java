package clone_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.UndirectedGraphNode;

public class CloneGraph {
    /*
        Clone Graph
        https://leetcode.com/problems/clone-graph/
        Difficulty: Medium
     */
    public class Solution {
        private UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
                                               HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node, newNode);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                if (newNeighbor == null) {
                    newNeighbor = cloneGraph(neighbor, map);
                }
                newNode.neighbors.add(newNeighbor);
            }
            return newNode;
        }

        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) {
                return null;
            }
            return cloneGraph(node,
                    new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
        }
    }

    public static class UnitTest {

    }
}
