package shortest_word_distance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ShortestWordDistance {
    /*
        Shortest Word Distance
        http://www.cnblogs.com/anne-vista/p/4831049.html
        Difficulty: Easy
    */
    public class Solution {
        public int shortestDistance(String[] words, String word1, String word2) {
            int p1 = -1, p2 = -1, distance = Integer.MAX_VALUE;

            for(int i = 0; i< words.length; i++){
                if(word1.equals(words[i])) {
                    p1 = i;
                }
                if(word2.equals(words[i])) {
                    p2 = i;
                }
                if(p1 != -1 && p2 != -1) {
                    distance = Math.min(distance, Math.abs(p1-p2));
                }
            }
            return distance;
        }
    }

    /*
        Shortest Word Distance II
        http://sbzhouhao.net/LeetCode/LeetCode-Shortest-Word-Distance-II.html
        Difficulty: Medium
    */
    public class SolutionII {
        private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        public SolutionII(String[] words) {
            for (int i = 0; i < words.length; i++) {
                String s = words[i];
                List<Integer> list;
                if (map.containsKey(s)) {
                    list = map.get(s);
                } else {
                    list = new ArrayList<Integer>();
                }
                list.add(i);
                map.put(s, list);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            int min = Integer.MAX_VALUE;

            for (int a : l1) {
                for (int b : l2) {
                    min = Math.min(Math.abs(b - a), min);
                }
            }
            return min;
        }
    }

    /*
        Shortest Word Distance III
        http://www.cnblogs.com/anne-vista/p/4831092.html
        Difficulty: Medium
    */
    public class SolutionIII {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            int p1 = -1, p2 = -1, distance = words.length;

            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    p1 = i;
                    if (p1 != -1 && p2 != -1) {
                        distance = (p1 != p2) ? Math.min(distance, Math.abs(p1 - p2)) : distance;
                    }
                }
                if (words[i].equals(word2)) {
                    p2 = i;
                    if (p1 != -1 && p2 != -1) {
                        distance = (p1 != p2) ? Math.min(distance, Math.abs(p1 - p2)) : distance;
                    }
                }
            }
            return distance;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ShortestWordDistance().new Solution();
            assertEquals(7, 7);
        }
    }
}
