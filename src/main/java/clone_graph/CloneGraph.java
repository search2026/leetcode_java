package clone_graph;

import common.UndirectedGraphNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class CloneGraph {
    /*
        Clone Graph - DFS
        Leetcode #133
        https://leetcode.com/problems/clone-graph/
        Difficulty: Medium
     */
    public class Solution {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            return clone(node);
        }

        private UndirectedGraphNode clone(UndirectedGraphNode node) {
            if (node == null) return null;
            if (visited.containsKey(node)) return visited.get(node);

            UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
            visited.put(node, copyNode);
            for (UndirectedGraphNode n : node.neighbors) {
                copyNode.neighbors.add(clone(n));
            }
            return copyNode;
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

            UndirectedGraphNode root = new UndirectedGraphNode(node.label);
            Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
            queue.add(node);
            Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
            visited.put(node, root);

            while (!queue.isEmpty()) {
                UndirectedGraphNode nodeInQueue = queue.poll();
                for (UndirectedGraphNode n : nodeInQueue.neighbors) {
                    if (visited.containsKey(n)) {
                        visited.get(nodeInQueue).neighbors.add(visited.get(n));
                    } else {
                        UndirectedGraphNode n_clone = new UndirectedGraphNode(n.label);
                        visited.get(nodeInQueue).neighbors.add(n_clone);
                        visited.put(n, n_clone);
                        queue.add(n);
                    }
                }
            }
            return root;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CloneGraph().new Solution();
            assertEquals(1, 1);
        }
    }
}
