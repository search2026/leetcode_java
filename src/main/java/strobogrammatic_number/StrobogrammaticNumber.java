package strobogrammatic_number;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrobogrammaticNumber {
    /*
        Strobogrammtic Number
        Leetcode #246
        http://buttercola.blogspot.com/2015/08/leetcode-strobogrammatic-number.html
        Difficulty: Easy
     */
    public class Solution {
        public boolean isStrobogrammatic(String num) {
            if (num == null || num.length() == 0) {
                return true;
            }

            int lo = 0;
            int hi = num.length() - 1;

            while (lo <= hi) {
                if (num.charAt(lo) == num.charAt(hi)) {
                    if (isStrobo(num.charAt(lo))) {
                        hi--;
                        lo++;
                    } else {
                        return false;
                    }
                } else {
                    if ((num.charAt(lo) == '6' && num.charAt(hi) == '9') ||
                            (num.charAt(lo) == '9' && num.charAt(hi) == '6')) {
                        hi--;
                        lo++;
                    } else {
                        return false;
                    }
                }
            }

            return true;
        }

        private boolean isStrobo(Character num) {
            return num == '0' || num == '1' || num == '8';
        }
    }

    /*
        Strobogrammtic Number II
        Leetcode #247
        http://buttercola.blogspot.com/2015/08/leetcode-strobogrammatic-number-ii.html
        Difficulty: Medium
     */
    public class SolutionII {
        private List<String> result = new ArrayList<String>();
        private Map<String, String> hashMap = new HashMap<String, String>();

        public List<String> findStrobogrammatic(int n) {
            result.clear();
            hashMap.clear();
            fillHashMap(hashMap);

            findStrobogrammaticHelper(n);

            return result;
        }

        private void findStrobogrammaticHelper(int n) {
            if (n <= 0) {
                return;
            }
            List<String> currResult = new ArrayList<String>();
            int size = 0;
            if (n == 1) {
                if (!result.isEmpty()) {
                    size = result.get(0).length();
                    int mid = size / 2;

                    for (String str : result) {
                        StringBuffer sb = new StringBuffer(str);
                        sb.insert(mid, '0');
                        currResult.add(sb.toString());

                        sb.setCharAt(mid, '1');
                        currResult.add(sb.toString());

                        sb.setCharAt(mid, '8');
                        currResult.add(sb.toString());
                    }
                    result.clear();
                    result.addAll(new ArrayList(currResult));
                } else {
                    result.add("0");
                    result.add("1");
                    result.add("8");
                }
            }

            if (n > 1) {
                if (result.isEmpty()) {
                    Iterator it = hashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        String elem = pair.getKey() + "" + pair.getValue();
                        if (!elem.equals("00")) {
                            result.add(elem);
                        }
                    }
                } else {
                    size = result.get(0).length();
                    int mid = size / 2;
                    for (String str : result) {
                        Iterator it = hashMap.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry pair = (Map.Entry) it.next();
                            StringBuffer sb = new StringBuffer(str);
                            String elem = pair.getKey() + "" + pair.getValue();
                            sb.insert(mid, elem);
                            currResult.add(sb.toString());
                        }
                    }
                    result.clear();
                    result.addAll(new ArrayList(currResult));
                }
            }

            findStrobogrammaticHelper(n - 2);
        }

        private void fillHashMap(Map<String, String> hashMap) {
            hashMap.put("0", "0");
            hashMap.put("1", "1");
            hashMap.put("8", "8");
            hashMap.put("6", "9");
            hashMap.put("9", "6");
        }
    }

    /*
        Strobogrammtic Number III
        Leetcode #248
        http://buttercola.blogspot.com/2015/09/leetcode-strobogrammatic-number-iii.html
        Difficulty: Hard
     */
    public class SolutionIII {
        private int count = 0;
        private Map<Character, Character> map = new HashMap<Character, Character>();

        public int strobogrammaticInRange(String low, String high) {
            if (low == null || low.length() == 0 || high == null || high.length() == 0) {
                return 0;
            }

            fillMap();

            for (int n = low.length(); n <= high.length(); n++) {
                char[] arr = new char[n];
                getStrobogrammaticNumbers(arr, 0, n - 1, low, high);
            }

            return count;
        }

        private void getStrobogrammaticNumbers(char[] arr, int start, int end, String low, String high) {
            if (start > end) {
                String s = new String(arr);
                if ((s.length() == 1 || s.charAt(0) != '0') && compare(low, s) && compare(s, high)) {
                    count++;
                }
                return;
            }

            for (char c : map.keySet()) {
                arr[start] = c;
                arr[end] = map.get(c);

                if ((start < end) || (start == end && map.get(c) == c)) {
                    getStrobogrammaticNumbers(arr, start + 1, end - 1, low, high);
                }
            }
        }

        // Return true if s1 <= s2
        private boolean compare(String s1, String s2) {
            if (s1.length() == s2.length()) {
                if (s1.compareTo(s2) <= 0) {
                    return true;
                } else {
                    return false;
                }
            }

            return true;
        }

        private void fillMap() {
            map.put('0', '0');
            map.put('1', '1');
            map.put('8', '8');
            map.put('6', '9');
            map.put('9', '6');
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new StrobogrammaticNumber().new Solution();
            assertEquals(7, 7);
        }
    }
}
