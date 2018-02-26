package clone_graph;

import common.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CloneGraph().new Solution();
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
        public void test2() {
            Solution_2 sol = new CloneGraph().new Solution_2();
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
}
