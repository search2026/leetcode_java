package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {

    /*
        Shortest Word Distance
        Leetcode #243
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/ShortestWordDistance.md
        Difficulty: Easy
    */
    public class Solution {
        public int shortestDistance(String[] words, String word1, String word2) {
            int idx = -1, minDist = Integer.MAX_VALUE;

            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1) || words[i].equals(word2)) {
                    if (idx != -1 && !words[idx].equals(words[i])) {
                        minDist = Math.min(minDist, i - idx);
                    }
                    idx = i;
                }
            }

            return minDist;
        }
    }

    /*
        Shortest Word Distance II
        Leetcode #244
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/ShortestWordDistanceII.md
        Difficulty: Medium
    */
    public class WordDistance {
        private Map<String, List<Integer>> map;

        public WordDistance(String[] words) {
            map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String w = words[i];
                if (map.containsKey(w)) {
                    map.get(w).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(w, list);
                }
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            int minDist = Integer.MAX_VALUE;
            for (int p1 = 0, p2 = 0; p1 < list1.size() && p2 < list2.size(); ) {
                int idx1 = list1.get(p1), idx2 = list2.get(p2);
                if (idx1 < idx2) {
                    minDist = Math.min(minDist, idx2 - idx1);
                    p1++;
                } else {
                    minDist = Math.min(minDist, idx1 - idx2);
                    p2++;
                }
            }
            return minDist;
        }
    }

    /*
        Shortest Word Distance III
        Leetcode #245
        https://github.com/search2026/leetcode_java/blob/master/problems201_300/resources/ShortestWordDistanceIII.md
        Difficulty: Medium
    */
    public class Solution_3 {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            long minDist = Integer.MAX_VALUE, p1 = minDist, p2 = Integer.MIN_VALUE;
            boolean same = word1.equals(word2);
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    if (same) {
                        p1 = p2;
                        p2 = i;
                    } else {
                        p1 = i;
                    }
                } else if (words[i].equals(word2)) {
                    p2 = i;
                }
                minDist = Math.min(minDist, Math.abs(p1 - p2));
            }
            return (int) minDist;
        }
    }

}
