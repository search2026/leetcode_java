package excel_sheet_column_title;

public class ExcelSheetColumnTitle {

    public class Solution {
        public String convertToTitle(int n) {
            StringBuilder builder = new StringBuilder();
            while (n != 0) {
                n--;
                char c = (char) (n % 26 + 'A');
                builder.append(c);
                n /= 26;
            }
            return builder.reverse().toString();
        }
    }

    public static class UnitTest {

    }
}

