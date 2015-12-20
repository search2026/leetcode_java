package zigzag_conversion;

public class ZigZagConversion {

    public class Solution {
        public String convert(String s, int numRows) {
            assert numRows >= 1;
            if (numRows == 1) {
                return s;
            }
            String ans = "";
            for (int j = 0; j < numRows; j++) {
                for (int i = 0; i + j < s.length(); i += 2 * (numRows - 1)) {
                    ans += s.charAt(i + j);
                    if (j == 0 || j == numRows - 1) {
                        continue;
                    }
                    int anotherIndex = i + j + (numRows - j - 1) * 2;
                    if (anotherIndex < s.length()) {
                        ans += s.charAt(anotherIndex);
                    }
                }
            }
            return ans;
        }
    }

    public static class UnitTest {

    }
}
