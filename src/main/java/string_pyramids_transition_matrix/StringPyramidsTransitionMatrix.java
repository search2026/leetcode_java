package string_pyramids_transition_matrix;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StringPyramidsTransitionMatrix {
    /*
        String Pyramids Transition Matrix
        http://massivealgorithms.blogspot.com/2017/07/string-pyramids-transition-matrix-airbnb.html
        Difficultly: Medium
     */
    public class Solution {
        private Set<Character> ruleSet;
        private Map<Character, Map<Character, Set<Character>>> transitionDict;
        private Map<String, Boolean> cache;

        public Solution(String[] lines, String rule) {
            ruleSet = new HashSet<>();
            for (int i = 0; i < rule.length(); i++) {
                ruleSet.add(rule.charAt(i));
            }

            transitionDict = new HashMap<>();
            for (String line : lines) {
                String[] parts = line.split(",");
                char left = parts[0].charAt(0);
                char right = parts[1].charAt(0);

                if (!transitionDict.containsKey(left)) {
                    transitionDict.put(left, new HashMap<>());
                }
                transitionDict.get(left).put(right, new HashSet<>());

                for (int i = 0; i < parts[2].length(); i++) {
                    transitionDict.get(left).get(right).add(parts[2].charAt(i));
                }
            }

            cache = new HashMap<>();
        }

        public boolean check(String input) {
            if (cache.containsKey(input)) {
                return cache.get(input);
            }

            if (input.length() == 1) {
                cache.put(input, ruleSet.contains(input.charAt(0)));
                return cache.get(input);
            }

            List<String> nextLevel = new ArrayList<>();
            getNextLevel(nextLevel, input, 0, new StringBuilder());

            for (String nextInput : nextLevel) {
                if (check(nextInput)) {
                    cache.put(input, true);
                    return true;
                }
            }

            cache.put(input, false);
            return false;
        }

        private void getNextLevel(List<String> res, String input, int start, StringBuilder sb) {
            if (start == input.length() - 1) {
                res.add(sb.toString());
                return;
            }

            char left = input.charAt(start);
            char right = input.charAt(start + 1);
            for (char c : transitionDict.get(left).get(right)) {
                sb.append(c);
                getNextLevel(res, input, start + 1, sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            String[] lines = {
                    "A,A,AC", "A,B,CD", "A,C,D", "A,D,B",
                    "B,A,B", "B,B,C", "B,C,A", "B,D,CD",
                    "C,A,A", "C,B,C", "C,C,D", "C,D,B",
                    "D,A,BC", "D,B,D", "D,C,A", "D,D,C"
            };
            Solution sol = new StringPyramidsTransitionMatrix().new Solution(lines, "CD");
            assertTrue(sol.check("ABCD"));
            assertFalse(sol.check("AACC"));
            assertTrue(sol.check("AAAA"));
        }
    }
}

