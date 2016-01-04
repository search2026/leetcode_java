package generalized_abbreviation;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class GeneralizedAbbreviation {
    /*
        Generalized Abbreviation
        https://segmentfault.com/a/1190000004187690
        Difficulty: Medium
     */
    public class Solution {
        public List<String> generateAbbreviations(String word) {
            List<String> rslt = new ArrayList<>();
            dfs(rslt, "", 0, word);
            return rslt;
        }

        public void dfs(List<String> rslt, String curr, int start, String s) {
            if (start > s.length())
                return;

            rslt.add(curr + s.substring(start));

            int i = 0;
            if (start > 0) {
                i = start + 1;
            }

            for (; i < s.length(); i++) {
                for (int j = 1; j <= s.length(); j++) {
                    dfs(rslt, curr + s.substring(start, i) + j, i + j, s);
                }
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new GeneralizedAbbreviation().new Solution();
        }        
    }
}

