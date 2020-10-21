package com.search2026.leetcode.problems;

public class WallsAndGates {
    /*
        Walls and Gates - BFS
        Leetcode #286
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/WallsAndGates.md
        Difficulty: Medium
     */
    public class Solution {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private void search(int[][] rooms, int i, int j, int dis) {
            if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) return;
            if (rooms[i][j] < dis) return;

            rooms[i][j] = dis;

            for (int[] dir : dirs)
                search(rooms, i + dir[0], j + dir[1], dis + 1);
        }

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

            for (int i = 0; i < rooms.length; ++i) {
                for (int j = 0; j < rooms[0].length; j++)
                    if (rooms[i][j] == 0) search(rooms, i, j, 0);
            }
        }
    }

    /*
        Walls and Gates - DFS
        Leetcode #286
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/WallsAndGates.md
        Difficulty: Medium
     */
    public class Solution_2 {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private void search(int[][] rooms, int i, int j, int d) {
            if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
            rooms[i][j] = d;
            for (int[] dir : dirs)
                search(rooms, i + dir[0], j + dir[1], d + 1);
        }

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

            for (int i = 0; i < rooms.length; i++)
                for (int j = 0; j < rooms[0].length; j++)
                    if (rooms[i][j] == 0) search(rooms, i, j, 0);
        }
    }

}
