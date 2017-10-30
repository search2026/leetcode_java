package csv_parser;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CSVParser {
    /*
        CSV Parser
        https://stackoverflow.com/questions/843997/csv-parsing-in-java-working-example
        Difficulty: Medium
     */
    public class Solution {
        public String parseCSV(String str) {
            List<String> items = new ArrayList<>();
            boolean inQuote = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (inQuote) {
                    if (str.charAt(i) == '\"') {
                        if (i < str.length() - 1 && str.charAt(i + 1) == '\"') {
                            sb.append("\"");
                            i++;
                        } else {
                            inQuote = false;
                        }
                    } else {
                        sb.append(str.charAt(i));
                    }
                } else {
                    if (str.charAt(i) == '\"') {
                        inQuote = true;
                    } else if (str.charAt(i) == ',') {
                        items.add(sb.toString());
                        sb.setLength(0);
                    } else {
                        sb.append(str.charAt(i));
                    }
                }
            }

            if (sb.length() > 0) {
                items.add(sb.toString());
            }
            return String.join("|", items);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CSVParser().new Solution();
            String test = "John,Smith,john.smith@gmail.com,Los Angeles,1";
            String expected = "John|Smith|john.smith@gmail.com|Los Angeles|1";
            assertEquals(expected, sol.parseCSV(test));

            test = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
            expected = "Jane|Roberts|janer@msn.com|San Francisco, CA|0";
            assertEquals(expected, sol.parseCSV(test));

            test = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
            expected = "Alexandra \"Alex\"|Menendez|alex.menendez@gmail.com|Miami|1";
            assertEquals(expected, sol.parseCSV(test));

            test = "\"\"\"Alexandra Alex\"\"\"";
            expected = "\"Alexandra Alex\"";
            assertEquals(expected, sol.parseCSV(test));
        }
    }
}

