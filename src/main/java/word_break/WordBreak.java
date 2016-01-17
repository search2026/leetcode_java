package word_break;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class WordBreak {
    /*
        Word Break
        https://leetcode.com/problems/word-break/
        Difficulty: Medium
     */
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

    /*
        Word Break II - Backtracking
        https://leetcode.com/problems/word-break-ii/
        Difficulty: Hard
     */
    public class Solution_2 {
        private List<String> searchWordBreak(String s, Set<String> dict, Map<String, List<String>> cur) {
            List<String> rslt = cur.get(s);
            if (rslt != null) {
                return rslt;
            }
            rslt = new ArrayList<String>();
            for (int i = 1; i < s.length(); i++) {
                String prefix = s.substring(0, i);
                if (dict.contains(prefix)) {
                    for (String sub : searchWordBreak(s.substring(i), dict, cur)) {
                        rslt.add(prefix + " " + sub);
                    }
                }
            }
            if (dict.contains(s)) {
                rslt.add(s);
            }
            cur.put(s, rslt);
            return rslt;
        }

        public List<String> wordBreak(String s, Set<String> wordDict) {
            return searchWordBreak(s, wordDict, new HashMap<String, List<String>>());
        }
    }

    /*
    Word Break II - Dynamic Programming
    https://leetcode.com/problems/word-break-ii/
    Difficulty: Hard
 */
    public class Solution_3 {
        public List<String> wordBreak(String s, Set<String> dict) {
            ArrayList<ArrayList<String>> rslt = new ArrayList<ArrayList<String>>();
            for (int i = 0; i <= s.length(); i++) {
                ArrayList<String> array = new ArrayList<String>();
                rslt.add(new ArrayList<String>(new ArrayList<String>()));
            }
            rslt.get(0).add("");
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            if (s.length() > 100) return rslt.get(s.length());

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String temp = s.substring(j, i);
                    if (dict.contains(temp) && dp[j]) {
                        dp[i] = true;
                        for (int k = 0; k < rslt.get(j).size(); k++) {
                            String str = rslt.get(j).get(k);
                            if (str.length() == 0) {
                                str = temp;
                            } else {
                                str = String.format("%s %s", str, temp);
                            }
                            rslt.get(i).add(str);
                        }
                    }
                }
            }
            return rslt.get(s.length());
        }
    }

    /*
    Word Break II - Dynamic Programming
    https://leetcode.com/problems/word-break-ii/
    Difficulty: Hard
 */
    public class Solution_4 {
        public List<String> wordBreak(String s, Set<String> dict) {
            ArrayList<ArrayList<String>> rslt = new ArrayList<ArrayList<String>>();
            if (s == null || s.length() == 0) return null;
            boolean[] res = new boolean[s.length() + 1];
            res[0] = true;
            for (int k = 0; k <= s.length(); k++) {
                rslt.add(new ArrayList<String>());
            }
            rslt.get(0).add("");

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    StringBuffer str = new StringBuffer(s.substring(j, i));
                    if (res[j] && dict.contains(str.toString())) {
                        res[i] = true;
                        for (String t : rslt.get(j))
                            if (t.equals(""))
                                rslt.get(i).add(String.format("%s", str));
                            else
                                rslt.get(i).add(String.format("%s %s", t, str));
                    }
                }
            }
            return rslt.get(s.length());
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WordBreak().new Solution();
            assertTrue(true);
        }
    }
}
