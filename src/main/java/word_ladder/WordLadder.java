package word_ladder;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class WordLadder {
    /*
        Word Ladder
        https://leetcode.com/problems/word-ladder/
        Difficulty: Medium
     */
    public class Solution {
        public int ladderLength(String start, String end, Set<String> dict) {
            if (start == null || start.isEmpty() || end == null || end.isEmpty()) return 0;
            int length = 1;
            Queue<String> queue = new LinkedList<String>();
            queue.offer(start);

            HashSet<String> visited = new HashSet<String>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    for (int j = 0; j < cur.length(); j++) {
                        char[] curChar = cur.toCharArray();
                        for (char c = 'a'; c < 'z'; c++) {
                            curChar[j] = c;
                            String curStr = new String(curChar);
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
        hhttps://leetcode.com/problems/word-ladder-ii/
        Difficulty: Hard
     */
    public class Solution_2 {
        public List<List<String>> findLadders(String start, String end, Set<String> dict) {
            List<List<String>> results = new ArrayList<List<String>>();
            if (start.isEmpty() || end.isEmpty() || dict.isEmpty())
                return results;
            Set<String> q1 = new HashSet<String>();
            Map<String, Set<String>> p = new HashMap<String, Set<String>>();
            q1.add(end);
            dict.add(end);
            dict.add(start);
            for (String i : dict) {
                Set<String> cur = new HashSet<String>();
                p.put(i, cur);
            }
            Set<String> visited = new HashSet<String>();
            boolean found = false;
            while (!q1.isEmpty() && !found) {
                for (String i : q1)
                    visited.add(i);
                Set<String> q2 = new HashSet<String>();
                for (String current : q1) {
                    char[] curChar = current.toCharArray();
                    for (int i = 0; i < current.length(); i++) {
                        char original = curChar[i];
                        for (char j = 'a'; j <= 'z'; j++) {
                            curChar[i] = j;
                            String newStr = new String(curChar);
                            if (!visited.contains(newStr) && dict.contains(newStr)) {
                                if (newStr.equals(start))
                                    found = true;
                                p.get(newStr).add(current);
                                q2.add(newStr);
                            }
                        }
                        curChar[i] = original;
                    }
                }
                q1 = q2;
            }

            List<String> result = new ArrayList<String>();
            if (found)
                search(result, start, p, results);

            return results;
        }

        void search(List<String> result, String start, Map<String, Set<String>> p, List<List<String>> results) {
            List<String> extendedResult = new ArrayList<String>(result);
            extendedResult.add(start);
            if (p.get(start).size() == 0) {
                results.add(extendedResult);
                return;
            }
            for (String s : p.get(start))
                search(extendedResult, s, p, results);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WordLadder().new Solution();
            assertEquals(3, 3);
        }
    }
}
