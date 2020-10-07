package com.search2026.leetcode.problems;

import java.util.*;

public class TheSkylineProblem {

    /*
         The Skyline Problem
         Leetcode #218
         https://leetcode.com/problems/the-skyline-problem/
         Difficulty: Hard
    */
    public class Solution {
        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> res = new ArrayList<>();

            if (buildings == null || buildings.length == 0
                        || buildings[0].length == 0) {
                return res;
            }

            List<Edge> edges = new ArrayList<>();

            // update all left/right edges
            for (int[] building : buildings) {
                Edge startEdge = new Edge(building[0], building[2], true);
                edges.add(startEdge);
                Edge endEdge = new Edge(building[1], building[2], false);
                edges.add(endEdge);
            }

            // sort edges
            Collections.sort(edges, new Comparator<Edge>() {
                public int compare(Edge a, Edge b) {
                    if (a.x != b.x)
                        return Integer.compare(a.x, b.x);

                    if (a.isStart && b.isStart) {
                        return Integer.compare(b.height, a.height);
                    }

                    if (!a.isStart && !b.isStart) {
                        return Integer.compare(a.height, b.height);
                    }

                    return a.isStart ? -1 : 1;
                }
            });

            // process edges
            PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());

            for (Edge edge : edges) {
                if (edge.isStart) {
                    if (heightHeap.isEmpty() || edge.height > heightHeap.peek()) {
                        res.add(new int[]{edge.x, edge.height});
                    }
                    heightHeap.add(edge.height);
                } else {
                    heightHeap.remove(edge.height);

                    if (heightHeap.isEmpty()) {
                        res.add(new int[]{edge.x, 0});
                    } else if (edge.height > heightHeap.peek()) {
                        res.add(new int[]{edge.x, heightHeap.peek()});
                    }
                }
            }

            return res;
        }
    }

    /*
         The Skyline Problem
         Leetcode #218
         https://leetcode.com/problems/the-skyline-problem/
         https://briangordon.github.io/2014/08/the-skyline-problem.html
         Difficulty: Hard
    */
    public class Solution_2 {
        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> res = new ArrayList<>();
            List<int[]> height = new ArrayList<>();
            for (int[] b : buildings) {
                height.add(new int[]{b[0], -b[2]});
                height.add(new int[]{b[1], b[2]});
            }
            Collections.sort(height, (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            });
            Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            pq.offer(0);
            int prev = 0;
            for (int[] h : height) {
                if (h[1] < 0) {
                    pq.offer(-h[1]);
                } else {
                    pq.remove(h[1]);
                }
                int cur = pq.peek();
                if (prev != cur) {
                    res.add(new int[]{h[0], cur});
                    prev = cur;
                }
            }
            return res;
        }
    }

    class Edge {
        int x;
        int height;
        boolean isStart;

        public Edge(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }

}
