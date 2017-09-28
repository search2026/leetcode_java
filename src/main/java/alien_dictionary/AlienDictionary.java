package alien_dictionary;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

import static org.junit.Assert.assertTrue;

public class AlienDictionary {
    /*
        Alien Dictionary
        Leetcode #269
        https://leetcode.com/discuss/questions/oj/alien-dictionary?sort=votes
        http://buttercola.blogspot.com/2015/09/leetcode-alien-dictionary.html
        Difficulty: Hard
     */
    public class Solution {
        private void generateIndegree(String[] words, HashMap<Character, HashSet<Character>> graph, HashMap<Character, Integer> indegree) {
            HashSet<String> edges = new HashSet<>();
            for (int i = 0; i < words.length - 1; i++) {
                String word1 = words[i];
                String word2 = words[i + 1];
                for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                    if (word1.charAt(j) == word2.charAt(j)) continue;
                    char from = word1.charAt(j);
                    char to = word2.charAt(j);
                    String edge = from + "" + to; //as a key to check duplicates
                    if (!edges.contains(edge)) {
                        graph.get(from).add(to);
                        indegree.put(to, indegree.get(to) + 1);
                        edges.add(edge);
                        break; // skip rest of characters
                    }
                }
            }
        }

        private String topologicalSort(HashMap<Character, HashSet<Character>> graph, HashMap<Character, Integer> inDegree) {
            StringBuilder order = new StringBuilder();
            Queue<Character> queue = new ArrayDeque<Character>();
            for (Character key : inDegree.keySet()) {
                if (inDegree.get(key) == 0) queue.offer(key);
            }

            while (!queue.isEmpty()) {
                Character cur = queue.poll();
                order.append(cur.charValue());
                HashSet<Character> adj = graph.get(cur);
                for (Character c : adj) {
                    int cInDegree = inDegree.get(c);
                    cInDegree--;
                    inDegree.put(c, cInDegree);
                    if (cInDegree == 0) queue.offer(c);
                }
            }
            return order.toString();
        }

        public String alienOrder(String[] words) {
            HashMap<Character, HashSet<Character>> graph = new HashMap<>();
            HashMap<Character, Integer> inDegree = new HashMap<>();

            for (String word : words) {
                for (int t = 0; t < word.length(); t++) {
                    if (!graph.containsKey(word.charAt(t))) {
                        graph.put(word.charAt(t), new HashSet<Character>());
                    }
                    if (!inDegree.containsKey(word.charAt(t))) {
                        inDegree.put(word.charAt(t), 0);
                    }
                }
            }

            generateIndegree(words, graph, inDegree);

            String order = topologicalSort(graph, inDegree);

            return (order.length() == inDegree.size()) ? order : "";
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new AlienDictionary().new Solution();
            String[] words = {
                    "wrt",
                    "wrf",
                    "er",
                    "ett",
                    "rftt"
            };
            assertTrue(sol.alienOrder(words).equals("wertf"));
        }
    }
}

