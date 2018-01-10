package minimum_cost_between_graph_nodes;

import java.util.*;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumCostBetweenGraphNodes {
    /*
        Minimum Cost Between Graph Nodes - BFS
        https://en.wikipedia.org/wiki/Shortest_path_problem
        Difficulty: Hard
     */
    public class Solution {
        public class Wizard {
            int idx, dis;

            public Wizard(int idx, int dis) {
                this.idx = idx;
                this.dis = dis;
            }
        }

        public int cost(List<List<Integer>> costList) {
            int n = costList.size();
            Wizard[] wizards = new Wizard[n];
            for (int i = 0; i < n; i++)
                wizards[i] = new Wizard(i, i == 0 ? 0 : Integer.MAX_VALUE);
            Queue<Wizard> queue = new LinkedList<>();
            queue.offer(wizards[0]);
            while (!queue.isEmpty()) {
                Wizard w = queue.poll();
                for (int i : costList.get(w.idx)) {
                    int newDis = w.dis + (w.idx - i) * (w.idx - i);
                    if (wizards[i].dis > newDis) {
                        wizards[i].dis = newDis;
                        queue.offer(wizards[i]);
                    }
                }
            }
            return wizards[n - 1].dis;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MinimumCostBetweenGraphNodes().new Solution();
            int[][] ids = {{1, 5, 9}, {2, 3, 9}, {4}, {}, {}, {9}, {}, {}, {}, {}};
            List<List<Integer>> wizards = new ArrayList<>();
            for (int i = 0; i < ids.length; i++) {
                List<Integer> wizard = new ArrayList<>();
                for (int j = 0; j < ids[i].length; j++) {
                    wizard.add(ids[i][j]);
                }
                wizards.add(wizard);
            }
            assertEquals(41, sol.cost(wizards));
        }
    }
}

