package number_of_connected_components_in_an_undirected_graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberofConnectedComponentsinanUndirectedGraph {
    /*
        Number of Connected Components in an Undirected Graph
        http://www.cnblogs.com/EdwardLiu/p/5088502.html
        Difficulty: Medium
     */
    public class Solution {
        public int countComponents(int n, int[][] edges) {
            unionFind uf = new unionFind(n);
            for (int[] edge : edges) {
                if (!uf.isConnected(edge[0], edge[1])) {
                    uf.union(edge[0], edge[1]);
                }
            }
            return uf.findCount();
        }

        public class unionFind {
            int[] ids;
            int count;

            public unionFind(int num) {
                this.ids = new int[num];
                for (int i = 0; i < num; i++) {
                    ids[i] = i;
                }
                this.count = num;
            }

            public int find(int i) {
                return ids[i];
            }

            public void union(int i1, int i2) {
                int id1 = find(i1);
                int id2 = find(i2);
                if (id1 != id2) {
                    for (int i = 0; i < ids.length; i++) {
                        if (ids[i] == id2) {
                            ids[i] = id1;
                        }
                    }
                    count--;
                }
            }

            public boolean isConnected(int i1, int i2) {
                return find(i1) == find(i2);
            }

            public int findCount() {
                return count;
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new NumberofConnectedComponentsinanUndirectedGraph().new Solution();
            int n = 5;
            int[][] edges = new int[][]{
                    new int[]{0, 1},
                    new int[]{1, 2},
                    new int[]{3, 4}
            };
            assertEquals(2, sol.countComponents(n, edges));
        }
    }
}

