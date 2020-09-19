package com.search2026.leetcode.problems;

import java.util.*;

public class WordLadder {

    /*
        Word Ladder
        Leetcode #127
        https://leetcode.com/problems/word-ladder/
        Difficulty: Medium
     */
    public class Solution {
        public int ladderLength(String start, String end, Set<String> dict) {
            if (start == null || start.isEmpty() || end == null || end.isEmpty()) return 0;
            int length = 1;
            Queue<String> queue = new LinkedList<>();
            queue.offer(start);

            HashSet<String> visited = new HashSet<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    for (int j = 0; j < cur.length(); j++) {
                        char[] newCand = cur.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == cur.charAt(j)) continue;
                            newCand[j] = c;
                            String curStr = new String(newCand);
                            if (curStr.equals(end)) {
                                return length + 1;
                            } else {
                                if (dict.contains(curStr) && !visited.contains(curStr)) {
                                    queue.offer(curStr);
                                    visited.add(curStr);
                                }
                            }
                        }
                    }
                }
                length++;
            }
            return 0;
        }
    }

    /*
        Word Ladder II
        Leetcode #126
        hhttps://leetcode.com/problems/word-ladder-ii/
        Difficulty: Hard
     */
    public class Solution_2 {
        private List<String> expand(String crt, Set<String> dict) {
            List<String> expansion = new ArrayList<>();

            for (int i = 0; i < crt.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != crt.charAt(i)) {
                        String expanded = crt.substring(0, i) + ch + crt.substring(i + 1);
                        if (dict.contains(expanded)) {
                            expansion.add(expanded);
                        }
                    }
                }
            }

            return expansion;
        }

        private void dfs(List<List<String>> ladders, List<String> path, String crt, String start, Map<String, Integer> distance, Map<String, List<String>> map) {
            path.add(crt);
            if (crt.equals(start)) {
                Collections.reverse(path);
                ladders.add(new ArrayList<>(path));
                Collections.reverse(path);
            } else {
                for (String next : map.get(crt)) {
                    if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
                        dfs(ladders, path, next, start, distance, map);
                    }
                }
            }
            path.remove(path.size() - 1);
        }

        private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
            Queue<String> q = new LinkedList<>();
            q.offer(start);
            distance.put(start, 0);
            for (String s : dict) {
                map.put(s, new ArrayList<>());
            }

            while (!q.isEmpty()) {
                String crt = q.poll();

                List<String> nextList = expand(crt, dict);
                for (String next : nextList) {
                    map.get(next).add(crt);
                    if (!distance.containsKey(next)) {
                        distance.put(next, distance.get(crt) + 1);
                        q.offer(next);
                    }
                }
            }
        }

        public List<List<String>> findLadders(String start, String end, Set<String> dict) {
            List<List<String>> ladders = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            Map<String, Integer> distance = new HashMap<>();

            dict.add(start);
            dict.add(end);

            bfs(map, distance, start, end, dict);

            dfs(ladders, new ArrayList<>(), end, start, distance, map);

            return ladders;
        }
    }

}
