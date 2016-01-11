package course_schedule;

import java.util.*;

public class CourseSchedule {
    /*
        Course Schedule
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
            if (numCourses <= 0) {
                return true;
            }

            if (prerequisites == null || prerequisites.length == 0) {
                return true;
            }

            // First transform the edge list to adj. list
            Map<Integer, List<Integer>> adjList = new HashMap<>();
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
            if (visited[vertexId] == -1) {
                return true;
            }

            if (visited[vertexId] == 1) {
                return false;
            }

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
        private int label;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0) {
                return new int[0];
            }
            this.label = numCourses - 1;

            int[] result = new int[numCourses];

            // No prerequisites
            if (prerequisites == null || prerequisites.length == 0) {
                for (int i = 0; i < numCourses; i++) {
                    result[i] = i;
                }

                return result;
            }

            // Convert the edge list to adj. list
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            for (int[] edge : prerequisites) {
                if (adjList.containsKey(edge[1])) {
                    List<Integer> neighbors = adjList.get(edge[1]);
                    neighbors.add(edge[0]);
                    adjList.put(edge[1], neighbors);
                } else {
                    List<Integer> neighbors = new ArrayList<Integer>();
                    neighbors.add(edge[0]);
                    adjList.put(edge[1], neighbors);
                }
            }

            int[] visited = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (!toplogicalSorting(i, visited, adjList, result)) {
                    return new int[0];
                }
            }

            return result;
        }

        private boolean toplogicalSorting(int vertexId, int[] visited, Map<Integer, List<Integer>> adjList, int[] result) {
            // Has been visited
            if (visited[vertexId] == -1) {
                return false;
            }

            // Has been added into the list
            if (visited[vertexId] == 1) {
                return true;
            }

            visited[vertexId] = -1;

            List<Integer> neighbors = adjList.get(vertexId);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!toplogicalSorting(neighbor, visited, adjList, result)) {
                        return false;
                    }
                }
            }

            result[label--] = vertexId;
            visited[vertexId] = 1;

            return true;
        }
    }
}

