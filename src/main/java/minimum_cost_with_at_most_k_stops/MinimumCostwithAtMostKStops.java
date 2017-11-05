package minimum_cost_with_at_most_k_stops;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class MinimumCostwithAtMostKStops {
    /*
        Minimum Cost with At Most K Stops - BFS
        Difficulty: Medium
     */
    public class Solution {
        private boolean search(Map<String, Node> nodes, String source, String target, int k, Map<String, String> parent) {
            boolean find = false;

            Queue<String> nodeQ = new LinkedList<>();
            Queue<Integer> costQ = new LinkedList<>();
            nodeQ.offer(source);
            costQ.offer(0);

            int stop = -1;
            while (!nodeQ.isEmpty()) {
                stop++;
                if (stop > k + 1) {
                    break;
                }
                int size = nodeQ.size();
                for (int i = 0; i < size; i++) {
                    Node cur = nodes.get(nodeQ.poll());
                    int curCost = costQ.poll();
                    cur.minCost = Math.min(cur.minCost, curCost);

                    if (cur.name.equals(target)) {
                        find = true;
                        continue;
                    }

                    for (String next : cur.nextNodes.keySet()) {
                        int nextCost = curCost + cur.nextNodes.get(next);
                        if (nextCost < nodes.get(next).minCost && (stop < k || stop == k && next.equals(target))) {
                            // Update path
                            parent.put(next, cur.name);
                            nodeQ.offer(next);
                            costQ.offer(nextCost);
                        }
                    }
                }
            }

            return find;
        }

        public int minCost(List<String> lines, String source, String target, int k) {
            if (lines.size() == 0 || k < 0) {
                return 0;
            }

            Map<String, Node> nodes = new HashMap<>();
            for (String line : lines) {
                String[] parts = line.split(",");
                String[] twoNodes = parts[0].split("->");
                if (!nodes.containsKey(twoNodes[0])) {
                    nodes.put(twoNodes[0], new Node(twoNodes[0]));
                }
                if (!nodes.containsKey(twoNodes[1])) {
                    nodes.put(twoNodes[1], new Node(twoNodes[1]));
                }
                nodes.get(twoNodes[0]).nextNodes.put(twoNodes[1], Integer.parseInt(parts[1]));
            }

            // Parent map for path
            Map<String, String> parent = new HashMap<>();

            boolean find = search(nodes, source, target, k, parent);

//            List<String> path = new ArrayList<>();
//            // Output path
//            if (find) {
//                String cur = target;
//                while (!cur.equals(source)) {
//                    path.add(cur);
//                    cur = parent.get(cur);
//                }
//                path.add(source);
//                Collections.reverse(path);
//                 System.out.println(path);
//            } else {
//                 System.out.println("");
//            }

            return find ? nodes.get(target).minCost : -1;
        }

        class Node {
            String name;
            int minCost;
            Map<String, Integer> nextNodes;

            Node(String name) {
                this.name = name;
                this.minCost = Integer.MAX_VALUE;
                this.nextNodes = new HashMap<>();
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MinimumCostwithAtMostKStops().new Solution();
            List<String> lines = new ArrayList<>();
            lines.add("A->B,100");
            lines.add("A->C,400");
            lines.add("B->C,100");
            lines.add("C->D,100");
            lines.add("C->A,10");
            assertEquals(-1, sol.minCost(lines, "A", "D", 0));
            assertEquals(500, sol.minCost(lines, "A", "D", 1));
            assertEquals(300, sol.minCost(lines, "A", "D", 2));
        }
    }
}

