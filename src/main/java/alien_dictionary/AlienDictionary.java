package alien_dictionary;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AlienDictionary {
    /*
        Alien Dictionary
        http://buttercola.blogspot.com/2015/09/leetcode-alien-dictionary.html
        Difficulty: Hard
     */
    public class Solution {
        public String alienOrder(String[] words) {
            // Step 1: build the graph
            Map<Character, Set<Character>> graph = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String curr = words[i];
                for (int j = 0; j < curr.length(); j++) {
                    if (!graph.containsKey(curr.charAt(j))) {
                        graph.put(curr.charAt(j), new HashSet<Character>());
                    }
                }

                if (i > 0) {
                    connectGraph(graph, words[i - 1], curr);
                }
            }

            // Step 2: toplogical sorting
            StringBuffer sb = new StringBuffer();
            Map<Character, Integer> visited = new HashMap<Character, Integer>();

            Iterator it = graph.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                char vertexId = (char) pair.getKey();
                if (!toplogicalSort(vertexId, graph, sb, visited)) {
                    return "";
                }
            }

            return sb.toString();
        }

        private void connectGraph(Map<Character, Set<Character>> graph, String prev, String curr) {
            if (prev == null || curr == null) {
                return;
            }

            int len = Math.min(prev.length(), curr.length());

            for (int i = 0; i < len; i++) {
                char p = prev.charAt(i);
                char q = curr.charAt(i);
                if (p != q) {
                    if (!graph.get(p).contains(q)) {
                        graph.get(p).add(q);
                    }
                    break;
                }
            }
        }

        private boolean toplogicalSort(char vertexId, Map<Character, Set<Character>> graph, StringBuffer sb,
                                       Map<Character, Integer> visited) {
            if (visited.containsKey(vertexId)) {
                // visited
                if (visited.get(vertexId) == -1) {
                    return false;
                }

                // already in the list
                if (visited.get(vertexId) == 1) {
                    return true;
                }
            } else {
                // mark as visited
                visited.put(vertexId, -1);
            }

            Set<Character> neighbors = graph.get(vertexId);
            for (char neighbor : neighbors) {
                if (!toplogicalSort(neighbor, graph, sb, visited)) {
                    return false;
                }
            }

            sb.insert(0, vertexId);
            visited.put(vertexId, 1);

            return true;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new AlienDictionary().new Solution();
        }
    }
}

