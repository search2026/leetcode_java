package word_ladder;

import java.util.*;

public class WordLadder {

    public class Solution {
        public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
            if (beginWord.equals(endWord)) {
                return 1;
            }
            List<String> queue = new ArrayList<String>();
            int level = 1;
            queue.add(beginWord);
            int begin = 0;
            char[] endCharArray = endWord.toCharArray();
            Set<String> used = new HashSet<String>();
            used.add(beginWord);
            while (begin < queue.size()) {
                int tail = queue.size();
                for (int i = begin; i < tail; i++) {
                    char[] word = queue.get(i).toCharArray();
                    for (int j = 0; j < word.length; j++) {
                        char currentChar = word[j];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == currentChar) {
                                continue;
                            }
                            word[j] = c;
                            if (Arrays.equals(word, endCharArray)) {
                                return level + 1;
                            }
                            String nextWord = new String(word);
                            if (wordList.contains(nextWord)
                                    && !used.contains(nextWord)) {
                                used.add(nextWord);
                                queue.add(nextWord);
                            }
                            word[j] = currentChar;
                        }
                    }
                }
                level++;
                begin = tail;
            }
            return 0;
        }
    }

    // Word Ladder II
    public class SolutionII {
        public List<List<String>> findLadders(String start, String end,
                                              Set<String> dict) {
            List<List<String>> ladders = new ArrayList<List<String>>();
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            Map<String, Integer> distance = new HashMap<String, Integer>();

            dict.add(start);
            dict.add(end);

            bfs(map, distance, start, end, dict);

            List<String> path = new ArrayList<String>();

            dfs(ladders, path, end, start, distance, map);

            return ladders;
        }

        void dfs(List<List<String>> ladders, List<String> path, String crt,
                 String start, Map<String, Integer> distance,
                 Map<String, List<String>> map) {
            path.add(crt);
            if (crt.equals(start)) {
                Collections.reverse(path);
                ladders.add(new ArrayList<String>(path));
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

        void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
                 String start, String end, Set<String> dict) {
            Queue<String> q = new LinkedList<String>();
            q.offer(start);
            distance.put(start, 0);
            for (String s : dict) {
                map.put(s, new ArrayList<String>());
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

        List<String> expand(String crt, Set<String> dict) {
            List<String> expansion = new ArrayList<String>();

            for (int i = 0; i < crt.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != crt.charAt(i)) {
                        String expanded = crt.substring(0, i) + ch
                                + crt.substring(i + 1);
                        if (dict.contains(expanded)) {
                            expansion.add(expanded);
                        }
                    }
                }
            }

            return expansion;
        }
    }

    public static class UnitTest {

    }
}
