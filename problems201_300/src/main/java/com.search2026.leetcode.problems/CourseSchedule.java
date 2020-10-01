package com.search2026.leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
            int[] res = new int[numCourses];

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++)
                graph.add(new ArrayList<>());
            int[] inDegree = new int[numCourses];
            for (int[] pre: prerequisites) {
                inDegree[pre[0]]++;
                graph.get(pre[1]).add(pre[0]);
            }

            Queue<Integer> leaves = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    leaves.offer(i);
                }
            }
            int count = 0;
            while (!leaves.isEmpty()) {
                int cur = leaves.poll();
                res[count++] = cur;
                for (Integer course: graph.get(cur)) {
                    inDegree[course]--;
                    if (inDegree[course] == 0) leaves.offer(course);
                }
            }
            //if cycle exists
            if (count != numCourses) return new int[0];
            return res;
        }
    }

}
