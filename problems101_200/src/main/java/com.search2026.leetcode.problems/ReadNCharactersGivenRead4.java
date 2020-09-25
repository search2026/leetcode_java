package com.search2026.leetcode.problems;

public class ReadNCharactersGivenRead4 {

    /*
        Read N Characters Given Read4
        Leetcode #157
        https://leetcode.com/discuss/questions/oj/read-n-characters-given-read4?sort=votes
        http://www.cnblogs.com/grandyang/p/5174322.html
        Difficulty: Hard
      */
    public class Solution {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return The number of characters read
         */
        public int read(char[] buf, int n) {
            char[] buffer = new char[4];
            int readBytes = 0;
            boolean eof = false;
            while (!eof && readBytes < n) {
                int sz = read4(buffer);
                if (sz < 4) eof = true;
                int bytes = Math.min(n - readBytes, sz);
                System.arraycopy(buffer /* src */, 0 /* srcPos */, buf /* dest */, readBytes /* destPos */, bytes /* length */);
                readBytes += bytes;
            }
            return readBytes;
        }
    }

    /*
        Read N Characters Given Read4 II
        Leetcode #158
        https://leetcode.com/discuss/questions/oj/read-n-characters-given-read4-ii-call-multiple-times?sort=votes
        http://www.cnblogs.com/grandyang/p/5181672.html
        Difficulty: Hard
      */
    public class Solution_2 {
        private char[] buffer = new char[4];
        int offset = 0, bufsize = 0;

        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return The number of characters read
         */
        public int read(char[] buf, int n) {
            int readBytes = 0;
            boolean eof = false;
            while (!eof && readBytes < n) {
                int sz = (bufsize > 0) ? bufsize : read4(buffer);
                if (bufsize == 0 && sz < 4) eof = true;
                int bytes = Math.min(n - readBytes, sz);
                System.arraycopy(buffer /* src */, offset /* srcPos */, buf /* dest */, readBytes /* destPos */, bytes /* length */);
                offset = (offset + bytes) % 4;
                bufsize = sz - bytes;
                readBytes += bytes;
            }
            return readBytes;
        }
    }


    // a fake function
    public int read4(char[] buffer) {
        return 4;
    }

}
