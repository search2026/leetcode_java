package restore_ip_addresses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestoreIPAddresses {
    /*
        Restore IP Addresses
        Leetcode #93
        https://leetcode.com/problems/restore-ip-addresses/
        Difficulty: Medium
     */
    public class Solution {
        private String toAddr(ArrayList<Integer> solution) {
            String addr = "";
            addr += solution.get(0);
            addr += ".";
            addr += solution.get(1);
            addr += ".";
            addr += solution.get(2);
            addr += ".";
            addr += solution.get(3);
            return addr;
        }

        private void search(String s, int start, ArrayList<Integer> cur, List<String> rslt) {
            if (start == s.length() && cur.size() == 4) {
                rslt.add(toAddr(cur));
                return;
            }
            if (s.length() - start > (4 - cur.size()) * 3) {
                return;
            }
            if (s.length() - start < 4 - cur.size()) {
                return;
            }
            int num = 0;
            for (int i = start; i < Math.min(start + 3, s.length()); i++) {
                num = num * 10 + s.charAt(i) - '0';
                if (num < 256) {
                    cur.add(num);
                    search(s, i + 1, cur, rslt);
                    cur.remove(cur.size() - 1);
                }
                if (num == 0) {
                    break;
                }
            }
        }

        public List<String> restoreIpAddresses(String s) {
            List<String> rslt = new ArrayList<String>();
            search(s, 0, new ArrayList<Integer>(), rslt);
            return rslt;
        }
    }

    /*
        Restore IP Addresses
        Leetcode #93
        https://leetcode.com/problems/restore-ip-addresses/
        Difficulty: Medium
    */
    public class Solution_2 {
        public boolean isValid(String str) {
            if (str == null || str.length() == 0) return false;
            if (str.length() > 3) return false;
            if (str.charAt(0) == '0' && str.length() > 1) return false;
            int value = Integer.parseInt(str);
            if (value < 0 || value > 255) return false;
            return true;
        }

        public void search(ArrayList<String> rslt, String cur, String s, int idx, int level) {
            if (level == 4) {
                String str = s.substring(idx);
                if (isValid(str)) {
                    cur = cur + "." + str;
                    rslt.add(cur);
                }
                return;
            }
            for (int i = idx; i < idx + 3 && i < s.length(); i++) {
                String str = s.substring(idx, i + 1);
                if (isValid(str)) {
                    if (cur.length() == 0) {
                        search(rslt, str, s, i + 1, level + 1);
                    } else {
                        search(rslt, cur + "." + str, s, i + 1, level + 1);
                    }
                }
            }
        }

        public List<String> restoreIpAddresses(String s) {
            ArrayList<String> rslt = new ArrayList<String>();
            search(rslt, "", s, 0, 1);
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RestoreIPAddresses().new Solution();
            assertEquals(7, 7);
        }
    }
}
