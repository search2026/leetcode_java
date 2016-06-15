package clone_graph;

import common.UndirectedGraphNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

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

            UndirectedGraphNode node_cloned = new UndirectedGraphNode(node.label);
            map.put(node, node_cloned);
            for (UndirectedGraphNode nbr : node.neighbors) {
                node_cloned.neighbors.add(clone(map, nbr));
            }

            return node_cloned;
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
            UndirectedGraphNode root_cloned = new UndirectedGraphNode(node.label);
            q.offer(node);
            map.put(node, root_cloned);

            while (!q.isEmpty()) {
                UndirectedGraphNode curr = q.poll();
                for (UndirectedGraphNode nbr : curr.neighbors) {
                    if (map.containsKey(nbr)) {
                        map.get(curr).neighbors.add(map.get(nbr));
                    } else {
                        UndirectedGraphNode nbr_cloned = new UndirectedGraphNode(nbr.label);
                        map.get(curr).neighbors.add(nbr_cloned);
                        q.offer(nbr);
                        map.put(nbr, nbr_cloned);
                    }
                }
            }

            return root_cloned;
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
