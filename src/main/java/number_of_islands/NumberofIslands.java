package number_of_islands;

import java.util.*;

public class NumberofIslands {

    public class Solution {
        // Number of Islands
        // https://leetcode.com/problems/number-of-islands/
        // Difficulty: Medium
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        merge(grid, i, j);
                    }
                }
            }
            return count;
        }

        public void merge(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
                return;

            if (grid[i][j] != '1') return;

            //set visited cell to '0'
            grid[i][j] = '0';
            //merge all adjacent land
            merge(grid, i - 1, j);
            merge(grid, i + 1, j);
            merge(grid, i, j - 1);
            merge(grid, i, j + 1);
        }
    }

    // Number of Islands II
    // http://blog.csdn.net/pointbreak1/article/details/49900853
    // Difficulty: Hard
    public class SolutionII {
        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            List<Integer> results = new ArrayList<Integer>();
            if (m <= 0 || n <= 0 || positions.length == 0)
                return results;
            //假设相邻的1都有相同的标识符，不相邻的1有不同的标识符，此为标识符到坐标列表的映射
            HashMap<Integer, List<Integer>> map1 = new HashMap<Integer, List<Integer>>();
            //用于快速查找某一位置的标识符
            HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
            //标识符
            int count = 1;
            for (int i = 0; i < positions.length; i++) {
                int r = positions[i][0], c = positions[i][1];
                int p = r * n + c;
                //收集邻居的标识符，加入到set中
                Set<Integer> candidate = new HashSet<Integer>();
                int top = r - 1 >= 0 ? (r - 1) * n + c : -1;
                int bot = r + 1 < m ? (r + 1) * n + c : -1;
                int left = c - 1 >= 0 ? r * n + (c - 1) : -1;
                int right = c + 1 < n ? r * n + (c + 1) : -1;
                if (map2.containsKey(top))
                    candidate.add(map2.get(top));
                if (map2.containsKey(bot))
                    candidate.add(map2.get(bot));
                if (map2.containsKey(left))
                    candidate.add(map2.get(left));
                if (map2.containsKey(right))
                    candidate.add(map2.get(right));
                //如set为空，说明没有相邻的1，加入新的1
                if (candidate.isEmpty()) {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(p);
                    map1.put(count, l);
                    map2.put(p, count);
                    count++;
                    //否则，需要merge邻居，统一他们的标识符
                } else {
                    Iterator iter = candidate.iterator();
                    int cur = (Integer) iter.next();
                    while (iter.hasNext()) {
                        int old = (Integer) iter.next();
                        for (int q : map1.get(old)) {
                            map2.put(q, cur);
                            map1.get(cur).add(q);
                        }
                        map1.remove(old);
                    }
                    map1.get(cur).add(p);
                    map2.put(p, cur);
                }
                //每次的岛数，为map1的size
                results.add(map1.size());
            }
            return results;
        }
    }

    public static class UnitTest {

    }
}
