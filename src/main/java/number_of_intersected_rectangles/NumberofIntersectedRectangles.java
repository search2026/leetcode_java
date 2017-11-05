package number_of_intersected_rectangles;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class NumberofIntersectedRectangles {
    /*
        Number of Intersected Rectangles - Union Find
        Similar to http://www.cnblogs.com/EdwardLiu/p/5088502.html
        Difficulty: Hard
     */
    public class Solution {
        public int countIntersection(int[][][] rectangles) {
            int[] parents = new int[rectangles.length];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < rectangles.length; i++) {
                for (int j = i + 1; j < rectangles.length; j++) {
                    if (intersect(rectangles[i], rectangles[j])) {
                        int root1 = find(i, parents);
                        int root2 = find(j, parents);

                        if (root1 != root2) {
                            parents[root1] = root2;
                        }
                    }
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < parents.length; i++) {
                set.add(find(i, parents));
            }

            return set.size();
        }

        private int find(int i, int[] parents) {
            int temp = i;
            while (parents[temp] != temp) {
                temp = parents[temp];
            }
            return temp;
        }

        private boolean intersect(int[][] r1, int[][] r2) {
            return r1[0][0] < r2[0][0] && r2[0][0] < r1[1][0] && r1[0][1] < r2[0][1] && r2[0][1] < r1[1][1] ||
                    r1[0][0] < r2[1][0] && r2[1][0] < r1[1][0] && r1[0][1] < r2[1][1] && r2[1][1] < r1[1][1];
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new NumberofIntersectedRectangles().new Solution();
            int[][][] rectangles = {
                    {{-3, -2}, {2, 1}},
                    {{10, 8}, {15, 10}},
                    {{1, 0}, {7, 4}},
                    {{12, 9}, {16, 12}},
                    {{-2, -1}, {5, 3}}
            };
            assertEquals(2, sol.countIntersection(rectangles));
        }
    }
}

