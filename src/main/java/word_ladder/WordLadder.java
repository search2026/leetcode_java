package word_ladder;

import java.util.*;

public class WordLadder {
    /*
        Word Ladder
        https://leetcode.com/problems/word-ladder/
        Difficulty: Medium
     */
    public class Solution {
        public int ladderLength(String start, String end, Set<String> dict) {
            if (start == null || start.isEmpty() || end == null || end.isEmpty())
                return 0;

            int length = 1;
            Queue<String> queue = new LinkedList<String>();
            queue.offer(start);

            HashSet<String> visited = new HashSet<String>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String curr = queue.poll();
                    for (int j = 0; j < curr.length(); j++) {
                        char[] charCurr = curr.toCharArray();
                        for (char c = 'a'; c < 'z'; c++) {
                            charCurr[j] = c;  // change one character at a time
                            String strCurr = new String(charCurr);
                            if (strCurr.equals(end)) {
                                return length + 1;
                            } else {
                                if (dict.contains(strCurr) && !visited.contains(strCurr)) {
                                    queue.offer(strCurr);
                                    visited.add(strCurr);
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
            if(start.isEmpty() || end.isEmpty() || dict.isEmpty())
                return results;
            Set<String> q1 = new HashSet<>();
            Map<String, Set<String>> p = new HashMap<>();
            q1.add(end);
            dict.add(end);
            dict.add(start);
            for(String i : dict) {
                Set<String> temp = new HashSet<>();
                p.put(i, temp);
            }
            Set<String> visited = new HashSet<>();
            boolean found = false;
            while(!q1.isEmpty() && !found) {
                for(String i : q1)
                    visited.add(i);
                Set<String> q2 = new HashSet<>();
                for(String current : q1) {
                    char[] curChar = current.toCharArray();
                    for(int i = 0; i < current.length(); i++) {
                        char original = curChar[i];
                        for(char j = 'a'; j <= 'z'; j++) {
                            curChar[i] = j;
                            String newStr = new String(curChar);
                            if(!visited.contains(newStr) && dict.contains(newStr)) {
                                if(newStr.equals(start))
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

            List<String> result = new ArrayList<>();
            if(found)
                generateResult(result, start, p, results);

            return results;
        }

        void generateResult(List<String> result, String start, Map<String, Set<String>> p, List<List<String>> results) {
            List<String> extendedResult = new ArrayList<>(result);
            extendedResult.add(start);
            if(p.get(start).size() == 0) {
                results.add(extendedResult);
                return;
            }
            for(String s : p.get(start))
                generateResult(extendedResult, s, p, results);
        }
    }

    public static class UnitTest {

    }
}
