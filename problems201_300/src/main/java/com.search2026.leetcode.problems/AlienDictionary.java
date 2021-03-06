package com.search2026.leetcode.problems;

import java.util.*;

public class AlienDictionary {

    /*
        Alien Dictionary - BFS
        Leetcode #269
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/AlienDictionary.md
        Difficulty: Hard
     */
    public class Solution {
        private final int N = 26;

        public boolean search(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
            visited[i] = 1;                            // 1 = visiting
            for (int j = 0; j < N; j++) {
                if (adj[i][j]) {                        // connected
                    if (visited[j] == 1) return false;  // 1 => 1, cycle
                    if (visited[j] == 0) {              // 0 = unvisited
                        if (!search(adj, visited, sb, j)) return false;
                    }
                }
            }
            visited[i] = 2;                           // 2 = visited
            sb.append((char) (i + 'a'));
            return true;
        }

        public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
            Arrays.fill(visited, -1);                 // -1 = not even existed
            for (int i = 0; i < words.length; i++) {
                for (char c : words[i].toCharArray()) visited[c - 'a'] = 0;
                if (i > 0) {
                    String w1 = words[i - 1], w2 = words[i];
                    int len = Math.min(w1.length(), w2.length());
                    for (int j = 0; j < len; j++) {
                        char c1 = w1.charAt(j), c2 = w2.charAt(j);
                        if (c1 != c2) {
                            adj[c1 - 'a'][c2 - 'a'] = true;
                            break;
                        }
                    }
                }
            }
        }

        public String alienOrder(String[] words) {
            boolean[][] adj = new boolean[N][N];
            int[] visited = new int[N];
            buildGraph(words, adj, visited);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (visited[i] == 0) {
                    if (!search(adj, visited, sb, i)) return "";
                }
            }
            return sb.reverse().toString();
        }
    }

    /*
        Alien Dictionary - Topological Sorting
        Leetcode #269
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/AlienDictionary.md
        Difficulty: Hard
     */
    public class Solution_2 {
        public String alienOrder(String[] words) {
            if (words == null || words.length == 0) return "";
            Map<Character, Set<Character>> dependency = new HashMap<>();
            int[] degree = new int[26];
            Set<Character> dict = new HashSet<>();
            StringBuilder sb = new StringBuilder();

            // save all characters which is used in the hash set
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    dict.add(c);
                }
            }

            // build dependency graph
            for (int i = 0; i < words.length - 1; i++) {
                char[] w1 = words[i].toCharArray(), w2 = words[i + 1].toCharArray();
                int len = Math.min(w1.length, w2.length);
                for (int j = 0; j < len; j++) {
                    char c1 = w1[j], c2 = w2[j];
                    if (c1 == c2) continue;

                    Set<Character> c2Set = dependency.containsKey(c1) ? dependency.get(c1) : new HashSet<>();
                    if (!c2Set.contains(c2)) {
                        c2Set.add(c2);
                        dependency.put(c1, c2Set);
                        degree[c2 - 'a']++;
                        break;
                    }
                }
            }

            // insert the nodes which have no parents
            Queue<Character> queue = new LinkedList<>();
            for (char c : dict) {
                if (degree[c - 'a'] == 0) queue.add(c);
            }

            // Topological Sorting
            while (!queue.isEmpty()) {
                char c1 = queue.poll();
                sb.append(c1);
                if (!dependency.containsKey(c1)) continue;
                for (char c2 : dependency.get(c1)) {
                    if (--degree[c2 - 'a'] == 0) queue.add(c2);
                }
            }

            // avoid the loop
            if (sb.length() != dict.size()) return "";
            return sb.toString();
        }
    }

}
