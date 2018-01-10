package course_schedule;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class CourseSchedule {
    /*
        Course Schedule - DFS
        Leetcode #207
        https://leetcode.com/problems/course-schedule/
        Difficulty: Medium
    */
    public class Solution {
        private boolean hasCycle(List<List<Integer>> adjList, int cur, int[] visited) {
            visited[cur] = 1;
            for (Integer next : adjList.get(cur)) {
                if (visited[next] == 1) {
                    return true;
                }
                if (hasCycle(adjList, next, visited)) {
                    return true;
                }
            }
            visited[cur] = 2;
            return false;
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0) return false;

            List<List<Integer>> adj = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                adj.add(new ArrayList<Integer>());
            }
            for (int[] p : prerequisites) {
                adj.get(p[0]).add(p[1]);
            }
            int[] visited = new int[numCourses];
            for (int i = 0; i < numCourses; ++i) {
                if (visited[i] == 0) {
                    if (hasCycle(adj, i, visited)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /*
        Course Schedule - Topological Sorting
        Leetcode #207
        https://leetcode.com/problems/course-schedule/
        Difficulty: Medium
    */
    public class Solution_2 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0) return false;

            int[] inDegree = new int[numCourses];
            List<List<Integer>> graph = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; i++)
                graph.add(new ArrayList<Integer>());
            for (int[] pre: prerequisites) {
                inDegree[pre[0]]++;
                graph.get(pre[1]).add(pre[0]);
            }

            Queue<Integer> leaves = new ArrayDeque<Integer>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    leaves.offer(i);
                }
            }

            int count = 0;
            while (!leaves.isEmpty()) {
                Integer cur = leaves.poll();
                count++;
                for (Integer course: graph.get(cur)) {
                    inDegree[course]--;
                    if (inDegree[course] == 0) leaves.offer(course);
                }
            }
            return count == numCourses;
        }
    }

    /*
        Course Schedule II
        Leetcode #210
        https://leetcode.com/problems/course-schedule-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0) return new int[0];
            int[] rslt = new int[numCourses];

            List<List<Integer>> graph = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; i++)
                graph.add(new ArrayList<Integer>());
            int[] inDegree = new int[numCourses];
            for (int[] pre: prerequisites) {
                inDegree[pre[0]]++;
                graph.get(pre[1]).add(pre[0]);
            }

            Queue<Integer> leaves = new ArrayDeque<Integer>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    leaves.offer(i);
                }
            }
            int count = 0;
            while (!leaves.isEmpty()) {
                int cur = leaves.poll();
                rslt[count++] = cur;
                for (Integer course: graph.get(cur)) {
                    inDegree[course]--;
                    if (inDegree[course] == 0) leaves.offer(course);
                }
            }
            //if cycle exists
            if (count != numCourses) return new int[0];
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CourseSchedule().new Solution();
            int n = 2;
            int[][] pre = new int[][]{
                    new int[]{1, 0}
            };
            assertTrue(sol.canFinish(n, pre));

            pre = new int[][]{
                    new int[]{1, 0},
                    new int[]{0, 1}
            };
            assertFalse(sol.canFinish(n, pre));
        }

        @Test
        public void test2() {
            Solution_2 sol = new CourseSchedule().new Solution_2();
            int n = 2;
            int[][] pre = new int[][]{
                    new int[]{1, 0}
            };
            assertTrue(sol.canFinish(n, pre));

            pre = new int[][]{
                    new int[]{1, 0},
                    new int[]{0, 1}
            };
            assertFalse(sol.canFinish(n, pre));
        }

        @Test
        public void test3() {
            Solution_3 sol = new CourseSchedule().new Solution_3();
            assertArrayEquals(new int[]{0, 1}, sol.findOrder(2, new int[][]{{1, 0}}));
            assertArrayEquals(new int[]{0, 1, 2, 3}, sol.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        }
    }
}

