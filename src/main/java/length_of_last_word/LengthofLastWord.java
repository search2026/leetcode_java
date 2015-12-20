package length_of_last_word;

public class LengthofLastWord {

    public class Solution {
        public int lengthOfLastWord(String s) {
            int i = s.length() - 1;
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) {
                return 0;
            }
            int len = 0;
            while (i >= 0 && s.charAt(i) != ' ') {
                len++;
                i--;
            }
            return len;
        }
    }

    public static class UnitTest {

    }
}
