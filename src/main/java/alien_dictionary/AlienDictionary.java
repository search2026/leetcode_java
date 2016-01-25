package alien_dictionary;

import org.junit.Test;

import java.util.*;

public class AlienDictionary {
    /*
        Alien Dictionary
        http://buttercola.blogspot.com/2015/09/leetcode-alien-dictionary.html
        Difficulty: Hard
     */
    public class Solution {
        public String alienOrder(String[] words) {
            HashMap<Character, HashSet<Character>> graph = new HashMap<Character, HashSet<Character>>();
            HashMap<Character, Integer> indegree = new HashMap<Character, Integer>();
            String order = "";
            initialization(words, graph, indegree);

            buildGraphCountIndegree(words, graph, indegree);

            order = topologicalSort(graph, indegree);

            return (order.length()==indegree.size())? order : "";
        }

        public void initialization(String[] words, HashMap<Character, HashSet<Character>> graph, HashMap<Character, Integer> indegree) {
            for (String each : words) {
                for (int t=0; t<each.length(); t++) {
                    if (!graph.containsKey(each.charAt(t))) {
                        graph.put(each.charAt(t), new HashSet<Character>());
                    }
                    if (!indegree.containsKey(each.charAt(t))) {
                        indegree.put(each.charAt(t), 0);
                    }
                }
            }
        }

        public void buildGraphCountIndegree(String[] words, HashMap<Character, HashSet<Character>> graph, HashMap<Character, Integer> indegree) {
            HashSet<String> edges = new HashSet<String>();
            for (int i=0; i<words.length-1; i++) {
                String word1 = words[i];
                String word2 = words[i+1];
                for (int j=0; j<word1.length()&&j<word2.length(); j++) {
                    if (word1.charAt(j) == word2.charAt(j)) continue;
                    char from = word1.charAt(j);
                    char to = word2.charAt(j);
                    String edge = from + "" + to;
                    if (!edges.contains(edge)) {
                        // add to node to from node's adjacent set
                        graph.get(from).add(to);

                        // increase to node's indegree by 1
                        indegree.put(to, indegree.get(to)+1);

                        // add the edge to visited set
                        edges.add(edge);
                        break;
                    }
                }
            }
        }

        public String topologicalSort(HashMap<Character, HashSet<Character>> graph, HashMap<Character, Integer> indegree) {
            StringBuffer rslt = new StringBuffer();
            LinkedList<Character> queue = new LinkedList<Character>();
            for (Character key : indegree.keySet()) {
                if (indegree.get(key) == 0) {
                    queue.offer(key);
                    //break;
                }
            }

            while (!queue.isEmpty()) {
                Character cur = queue.poll();
                rslt.append(cur.charValue());
                HashSet<Character> adjList = graph.get(cur);
                if (adjList != null) {
                    for (Character dst : adjList) {
                        int dstIndegree = indegree.get(dst);
                        dstIndegree--;
                        if (dstIndegree == 0) queue.offer(dst);
                        indegree.put(dst, dstIndegree);
                    }
                }
            }
            return rslt.toString();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new AlienDictionary().new Solution();
        }
    }
}

