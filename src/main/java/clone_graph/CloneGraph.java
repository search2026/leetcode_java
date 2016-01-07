package clone_graph;

import common.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CloneGraph {
    /*
        Clone Graph - DFS
        https://leetcode.com/problems/clone-graph/
        Difficulty: Medium
     */
    public class Solution {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            return clone(node);
        }

        private UndirectedGraphNode clone(UndirectedGraphNode node) {
            if (node == null) return null;
            if (map.containsKey(node)) return map.get(node);

            UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
            map.put(node, copyNode);
            for (UndirectedGraphNode n : node.neighbors) {
                copyNode.neighbors.add(clone(n));
            }
            return copyNode;
        }
    }

    /*
        Clone Graph - BFS
        https://leetcode.com/problems/clone-graph/
        Difficulty: Medium
    */
    public class Solution_2 {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) return null;

            UndirectedGraphNode rslt = new UndirectedGraphNode(node.label);
            LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
            queue.add(node);
            Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
            map.put(node, rslt);

            while (!queue.isEmpty()) {
                UndirectedGraphNode nodeInQueue = queue.poll();
                for (UndirectedGraphNode n : nodeInQueue.neighbors) {
                    //UndirectedGraphNode n1 = neighbors.get(i);
                    if (map.containsKey(n)) {
                        map.get(nodeInQueue).neighbors.add(map.get(n));
                    } else {
                        UndirectedGraphNode n_clone = new UndirectedGraphNode(n.label);
                        map.get(nodeInQueue).neighbors.add(n_clone);
                        map.put(n, n_clone);
                        queue.add(n);
                    }
                }
            }
            return rslt;
        }
    }


    public static class UnitTest {

    }
}
