package course_schedule;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class CourseSchedule {
    /*
        Course Schedule - BFS
        https://leetcode.com/problems/course-schedule/
        Difficulty: Medium
     */
    public class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> outNodes = new HashMap<Integer, List<Integer>>();
            int[] inDegree = new int[numCourses];
            Set<Integer> courses = new HashSet<Integer>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                courses.add(i);
                outNodes.put(i, new ArrayList<Integer>());
            }
            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                inDegree[to]++;
                List<Integer> nodes = outNodes.get(from);
                nodes.add(to);
            }
            while (!courses.isEmpty()) {
                List<Integer> toRemoved = new ArrayList<Integer>();
                for (int course : courses) {
                    if (inDegree[course] == 0) {
                        toRemoved.add(course);
                        for (int node : outNodes.get(course)) {
                            inDegree[node]--;
                        }
                    }
                }
                if (toRemoved.isEmpty()) {
                    return false;
                }
                courses.removeAll(toRemoved);
            }
            return true;
        }
    }

    /*
        Course Schedule - DFS
        https://leetcode.com/problems/course-schedule/
        Difficulty: Medium
    */
    public class Solution_2 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0) return true;
            if (prerequisites == null || prerequisites.length == 0) return true;

            // First transform the edge list to adj. list
            Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
            for (int[] edge : prerequisites) {
                if (adjList.containsKey(edge[0])) {
                    List<Integer> neighbors = adjList.get(edge[0]);
                    neighbors.add(edge[1]);
                    adjList.put(edge[0], neighbors);
                } else {
                    List<Integer> neighbors = new ArrayList<Integer>();
                    neighbors.add(edge[1]);
                    adjList.put(edge[0], neighbors);
                }
            }

            int[] visited = new int[numCourses];
            // Check if the graph contains a circle, if yes, return false.
            for (int i = 0; i < numCourses; i++) {
                if (hasCircles(i, visited, adjList)) {
                    return false;
                }
            }

            return true;
        }

        private boolean hasCircles(int vertexId, int[] visited, Map<Integer, List<Integer>> adjList) {
            if (visited[vertexId] == -1) return true;
            if (visited[vertexId] == 1) return false;

            visited[vertexId] = -1;
            List<Integer> neighbors = adjList.get(vertexId);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (hasCircles(neighbor, visited, adjList)) {
                        return true;
                    }
                }
            }
            visited[vertexId] = 1;

            return false;
        }
    }

    /*
        Course Schedule II
        https://leetcode.com/problems/course-schedule-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] result = new int[numCourses];
            if (numCourses <= 0) return new int[0];

            int len = prerequisites.length;
            int[] countPre = new int[numCourses];
            for (int i = 0; i < len; i++) {
                countPre[prerequisites[i][0]]++;
            }
            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 0; i < numCourses; i++) {
                if (countPre[i] == 0) {
                    q.offer(i);
                }
            }
            int count = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                result[count++] = cur;
                for (int i = 0; i < len; i++) {
                    if (prerequisites[i][1] == cur) {
                        countPre[prerequisites[i][0]]--;
                        if (countPre[prerequisites[i][0]] == 0) {
                            q.offer(prerequisites[i][0]);
                        }
                    }
                }
            }
            //if cycle exists
            if (count != numCourses) return new int[0];
            return result;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CourseSchedule().new Solution();
            assertTrue(sol.canFinish(2, new int[][]{{1, 0}}));
        }

        @Test
        public void test2() {
            Solution_3 sol = new CourseSchedule().new Solution_3();
            assertArrayEquals(new int[]{0, 1}, sol.findOrder(2, new int[][]{{1, 0}}));
            assertArrayEquals(new int[]{0, 1, 2, 3}, sol.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        }
    }
}

