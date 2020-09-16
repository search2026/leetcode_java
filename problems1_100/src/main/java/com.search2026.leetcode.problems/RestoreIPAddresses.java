package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    /*
        Restore IP Addresses
        Leetcode #93
        https://leetcode.com/problems/restore-ip-addresses/
        Difficulty: Medium
     */
    public class Solution {
        private String toAddress(ArrayList<Integer> solution) {
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

        private void search(String s, int start, ArrayList<Integer> cur, List<String> res) {
            if (start == s.length() && cur.size() == 4) {
                res.add(toAddress(cur));
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
                    search(s, i + 1, cur, res);
                    cur.remove(cur.size() - 1);
                }
                if (num == 0) {
                    break;
                }
            }
        }

        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            search(s, 0, new ArrayList<>(), res);
            return res;
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

        public void search(ArrayList<String> res, String curr, String s, int idx, int level) {
            if (level == 4) {
                String str = s.substring(idx);
                if (isValid(str)) {
                    curr = curr + "." + str;
                    res.add(curr);
                }
                return;
            }
            for (int i = idx; i < idx + 3 && i < s.length(); i++) {
                String str = s.substring(idx, i + 1);
                if (isValid(str)) {
                    if (curr.length() == 0) {
                        search(res, str, s, i + 1, level + 1);
                    } else {
                        search(res, curr + "." + str, s, i + 1, level + 1);
                    }
                }
            }
        }

        public List<String> restoreIpAddresses(String s) {
            ArrayList<String> res = new ArrayList<>();
            search(res, "", s, 0, 1);
            return res;
        }
    }

}
