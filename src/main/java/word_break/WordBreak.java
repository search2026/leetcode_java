package word_break;

import java.util.*;

public class WordBreak {

    public class Solution {
        public boolean wordBreak(String s, Set<String> dict) {
            assert !s.isEmpty();
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                dp[i] = false;
                for (int j = 0; j < i; j++) {
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    // Word Break II
    public class SolutionII {
        private ArrayList<String> searchWordBreak(String s, Set<String> dict,
                                                  Map<String, ArrayList<String>> solutions) {
            ArrayList<String> solution = solutions.get(s);
            if (solution != null) {
                return solution;
            }
            solution = new ArrayList<String>();
            for (int i = 1; i < s.length(); i++) {
                String prefix = s.substring(0, i);
                if (dict.contains(prefix)) {
                    for (String subfix : searchWordBreak(s.substring(i), dict,
                            solutions)) {
                        solution.add(prefix + " " + subfix);
                    }
                }
            }
            if (dict.contains(s)) {
                solution.add(s);
            }
            solutions.put(s, solution);
            return solution;
        }

        public List<String> wordBreak(String s, Set<String> wordDict) {
            return searchWordBreak(s, wordDict,
                    new HashMap<String, ArrayList<String>>());
        }
    }

    public static class UnitTest {

    }
}
